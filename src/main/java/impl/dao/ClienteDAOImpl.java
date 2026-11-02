package impl.dao;

import conexion.ConexionDB;
import dao.ClienteDAO;
import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public boolean registrar(Cliente c) {
        String sql = "INSERT INTO Clientes (IdUsuario, Nombre, DNI, Telefono, Correo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, c.getIdUsuario());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getCorreo());
            
            // CORRECCIÓN: Usar execute() en lugar de executeUpdate()
            ps.execute(); 
            return ps.getUpdateCount() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error registrar cliente:");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cliente buscarPorId(int idCliente) {
        String sql = "SELECT * FROM Clientes WHERE IdCliente = ?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                        rs.getInt("IdCliente"), 
                        rs.getInt("IdUsuario"),
                        rs.getString("Nombre"), 
                        rs.getString("DNI"),
                        rs.getString("Telefono"), 
                        rs.getString("Correo")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error buscar cliente:");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Connection conn = ConexionDB.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Cliente(
                    rs.getInt("IdCliente"), 
                    rs.getInt("IdUsuario"),
                    rs.getString("Nombre"), 
                    rs.getString("DNI"),
                    rs.getString("Telefono"), 
                    rs.getString("Correo")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error listar clientes:");
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean actualizar(Cliente c) {
        String sql = "UPDATE Clientes SET IdUsuario=?, Nombre=?, DNI=?, Telefono=?, Correo=? WHERE IdCliente=?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, c.getIdUsuario());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getCorreo());
            ps.setInt(6, c.getIdCliente());
            
            // CORRECCIÓN: Usar execute() en lugar de executeUpdate()
            ps.execute();
            return ps.getUpdateCount() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error actualizar cliente:");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int idCliente) {
        String sql = "DELETE FROM Clientes WHERE IdCliente = ?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idCliente);
            
            // CORRECCIÓN: Usar execute() en lugar de executeUpdate()
            ps.execute();
            return ps.getUpdateCount() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error eliminar cliente:");
            e.printStackTrace();
            return false;
        }
    }
}