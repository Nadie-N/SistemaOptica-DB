package controller;

import impl.dao.ProductoDAOImpl;
import model.Producto;
import java.util.List;

public class InventarioController {
    
    private ProductoDAOImpl productoDAO;

    public InventarioController() {
        this.productoDAO = new ProductoDAOImpl();
    }

    // Método unificado para registrar cualquier producto (Aro, Luna o Accesorio)
    public boolean registrarProducto(Producto p) {
        return productoDAO.registrar(p);
    }

    // Método para listar según la pestaña (le pasas "ARO", "LUNA" o "ACCESORIO")
    public List<Producto> listarPorTipo(String tipo) {
        return productoDAO.listarPorTipo(tipo);
    }
}