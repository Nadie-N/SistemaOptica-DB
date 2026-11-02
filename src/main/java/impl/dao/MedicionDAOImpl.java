package impl.dao;

import conexion.ConexionDB;
import dao.MedicionDAO;
import model.Medicion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicionDAOImpl implements MedicionDAO {

    @Override
    public boolean registrar(Medicion m) {
        String sql = "INSERT INTO mediciones (idCliente, fechaMedicion, esfera, cilindro, eje, adicion, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, m.getIdCliente());
            ps.setString(2, String.valueOf(m.getFechaMedicion())); 
            ps.setDouble(3, m.getEsfera());
            ps.setDouble(4, m.getCilindro());
            ps.setInt(5, m.getEje());
            ps.setDouble(6, m.getAdicion());
            ps.setString(7, m.getObservaciones());
            
            ps.execute(); // Usamos execute() por el driver de Turso
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error registrar medición: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Medicion buscarPorId(int idMedicion) {
        String sql = "SELECT * FROM mediciones WHERE idMedicion = " + idMedicion;
        try (Connection conn = ConexionDB.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return mapearMedicion(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error buscar medición: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Medicion> listarPorCliente(int idCliente) {
        List<Medicion> lista = new ArrayList<>();
        
        // PRUEBA: Traemos todas las mediciones para ver si se muestran en la tabla
        String sql = "SELECT * FROM mediciones"; 
        
        try (Connection conn = ConexionDB.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
             
            System.out.println("--- CONSULTANDO BD (SIN FILTRO) ---");
            
            while (rs.next()) {
                System.out.println("Leyendo ID: " + rs.getInt("idMedicion") + 
                                   " | Cliente en BD: " + rs.getInt("idCliente"));
                lista.add(mapearMedicion(rs));
            }
            System.out.println("Total leídos de la BD: " + lista.size());
            
        } catch (SQLException e) {
            System.out.println("Error SQL al listar: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean actualizar(Medicion m) {
        String sql = "UPDATE mediciones SET idCliente=?, fechaMedicion=?, esfera=?, cilindro=?, eje=?, adicion=?, observaciones=? WHERE idMedicion=?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, m.getIdCliente());
            ps.setString(2, String.valueOf(m.getFechaMedicion()));
            ps.setDouble(3, m.getEsfera());
            ps.setDouble(4, m.getCilindro());
            ps.setInt(5, m.getEje());
            ps.setDouble(6, m.getAdicion());
            ps.setString(7, m.getObservaciones());
            ps.setInt(8, m.getIdMedicion());
            
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error actualizar medición: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int idMedicion) {
        String sql = "DELETE FROM mediciones WHERE idMedicion = ?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMedicion);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error eliminar medición: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Método auxiliar para leer los datos de forma segura
    private Medicion mapearMedicion(ResultSet rs) throws SQLException {
        Medicion m = new Medicion();
        m.setIdMedicion(rs.getInt("idMedicion"));
        m.setIdCliente(rs.getInt("idCliente"));
        
        String fechaStr = rs.getString("fechaMedicion");
        if (fechaStr != null && fechaStr.length() >= 10) {
            try {
                m.setFechaMedicion(java.sql.Date.valueOf(fechaStr.substring(0, 10)));
            } catch (Exception e) {
                m.setFechaMedicion(new java.sql.Date(System.currentTimeMillis()));
            }
        }
        
        m.setEsfera(rs.getDouble("esfera"));
        m.setCilindro(rs.getDouble("cilindro"));
        m.setEje(rs.getInt("eje"));
        m.setAdicion(rs.getDouble("adicion"));
        m.setObservaciones(rs.getString("observaciones"));
        
        return m;
    }
}