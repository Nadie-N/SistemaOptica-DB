package impl.dao;

import conexion.ConexionDB;
import dao.VentaDAO;
import model.Venta;
import model.DetalleVenta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOImpl implements VentaDAO {

    // Método especializado para guardar venta + detalles
    public boolean registrarVenta(Venta venta, List<DetalleVenta> detalles) {
        String sqlVenta = "INSERT INTO Ventas (IdCliente, IdVendedor, IdMedicion, IdAro, FechaVenta, Subtotal, Impuesto, Total) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlDetalle = "INSERT INTO DetalleVenta (IdVenta, IdProducto, Cantidad, PrecioUnitario, Subtotal) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConexion()) {
            // NOTA: Se eliminó conn.setAutoCommit(false) porque Turso no lo soporta.

            // 1. Insertar la cabecera de la venta
            try (PreparedStatement psVenta = conn.prepareStatement(sqlVenta)) {
                psVenta.setInt(1, venta.getIdCliente());
                psVenta.setInt(2, venta.getIdVendedor());
                psVenta.setInt(3, venta.getIdMedicion());
                psVenta.setInt(4, venta.getIdAro());
                psVenta.setDate(5, venta.getFechaVenta());
                psVenta.setDouble(6, venta.getSubtotal());
                psVenta.setDouble(7, venta.getImpuesto());
                psVenta.setDouble(8, venta.getTotal());
                psVenta.execute(); // Usamos execute()
            }

            // 2. Obtener el ID generado usando la función nativa de SQLite
            int idVentaGenerado = 0;
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT last_insert_rowid()")) {
                if (rs.next()) {
                    idVentaGenerado = rs.getInt(1);
                }
            }

            // 3. Insertar los detalles uno por uno
            try (PreparedStatement psDetalle = conn.prepareStatement(sqlDetalle)) {
                for (DetalleVenta det : detalles) {
                    psDetalle.setInt(1, idVentaGenerado);
                    psDetalle.setInt(2, det.getIdProducto()); 
                    psDetalle.setInt(3, det.getCantidad());
                    psDetalle.setDouble(4, det.getPrecioUnitario());
                    psDetalle.setDouble(5, det.getSubtotal());
                    psDetalle.execute(); // Insertamos uno por uno
                }
            }
            
            System.out.println("✅ Venta y detalles registrados con éxito en BD.");
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al registrar venta: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean registrar(Venta venta) {
        String sql = "INSERT INTO Ventas (IdCliente, IdVendedor, IdMedicion, IdAro, FechaVenta, Subtotal, Impuesto, Total) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, venta.getIdCliente());
            ps.setInt(2, venta.getIdVendedor());
            ps.setInt(3, venta.getIdMedicion());
            ps.setInt(4, venta.getIdAro());
            ps.setDate(5, venta.getFechaVenta());
            ps.setDouble(6, venta.getSubtotal());
            ps.setDouble(7, venta.getImpuesto());
            ps.setDouble(8, venta.getTotal());
            
            ps.execute(); 
            return true;
        } catch (SQLException e) {
            System.out.println("Error registrar venta cabecera: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Venta buscarPorId(int idVenta) {
        String sql = "SELECT * FROM Ventas WHERE IdVenta = ?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Venta(
                        rs.getInt("IdVenta"), rs.getInt("IdCliente"), rs.getInt("IdVendedor"),
                        rs.getInt("IdMedicion"), rs.getInt("IdAro"), rs.getDate("FechaVenta"),
                        rs.getDouble("Subtotal"), rs.getDouble("Impuesto"), rs.getDouble("Total")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error buscar venta: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Venta> listar() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ventas";
        try (Connection conn = ConexionDB.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Venta(
                    rs.getInt("IdVenta"), rs.getInt("IdCliente"), rs.getInt("IdVendedor"),
                    rs.getInt("IdMedicion"), rs.getInt("IdAro"), rs.getDate("FechaVenta"),
                    rs.getDouble("Subtotal"), rs.getDouble("Impuesto"), rs.getDouble("Total")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error listar ventas: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean actualizar(Venta venta) {
        String sql = "UPDATE Ventas SET IdCliente=?, IdVendedor=?, IdMedicion=?, IdAro=?, FechaVenta=?, Subtotal=?, Impuesto=?, Total=? WHERE IdVenta=?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, venta.getIdCliente());
            ps.setInt(2, venta.getIdVendedor());
            ps.setInt(3, venta.getIdMedicion());
            ps.setInt(4, venta.getIdAro());
            ps.setDate(5, venta.getFechaVenta());
            ps.setDouble(6, venta.getSubtotal());
            ps.setDouble(7, venta.getImpuesto());
            ps.setDouble(8, venta.getTotal());
            ps.setInt(9, venta.getIdVenta());
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error actualizar venta: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int idVenta) {
        String sql = "DELETE FROM Ventas WHERE IdVenta = ?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error eliminar venta: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}