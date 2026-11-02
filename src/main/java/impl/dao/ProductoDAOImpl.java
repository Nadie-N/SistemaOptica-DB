package impl.dao;

import conexion.ConexionDB;
import model.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl {

    public boolean registrar(Producto p) {
    String sql = "INSERT INTO Productos (Nombre, TipoProducto, Marca, Material, Forma, Precio, Stock) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, p.getNombre());
        ps.setString(2, p.getTipoProducto());
        ps.setString(3, p.getMarca());
        ps.setString(4, p.getMaterial());
        ps.setString(5, p.getForma());
        ps.setDouble(6, p.getPrecio());
        ps.setInt(7, p.getStock());
        
        // CAMBIO CLAVE: Usar execute() en lugar de executeUpdate()
        ps.execute();
        return true; // Si no lanzó excepción, se insertó correctamente
        
    } catch (SQLException e) {
        System.out.println("Error real al registrar producto: " + e.getMessage());
        e.printStackTrace(); 
        return false;
    }
}

    public List<Producto> listarPorTipo(String tipo) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Productos WHERE TipoProducto = ?";
        
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, tipo);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Producto(
                        rs.getInt("IdProducto"), 
                        rs.getString("Nombre"),
                        rs.getString("TipoProducto"), 
                        rs.getString("Marca"),
                        rs.getString("Material"), 
                        rs.getString("Forma"),
                        rs.getDouble("Precio"), 
                        rs.getInt("Stock")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error listar productos: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
}