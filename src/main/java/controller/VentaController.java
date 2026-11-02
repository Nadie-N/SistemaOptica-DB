package controller;

import impl.dao.VentaDAOImpl;
import model.Venta;
import model.DetalleVenta;
import java.util.List;

public class VentaController {
    
    private VentaDAOImpl ventaDAO;

    public VentaController() {
        this.ventaDAO = new VentaDAOImpl();
    }

    /**
     * Procesa y guarda una venta completa junto con sus detalles.
     * @param venta La cabecera de la venta (con totales, cliente, vendedor).
     * @param detalles La lista de productos (aros, lunas, etc.) que se llevan.
     * @return true si se guardó correctamente, false si hubo un error.
     */
    public boolean procesarVenta(Venta venta, List<DetalleVenta> detalles) {
        // Validaciones de negocio
        if (venta == null) {
            System.out.println("Error: La venta está vacía.");
            return false;
        }
        
        if (detalles == null || detalles.isEmpty()) {
            System.out.println("Error: No hay productos en el carrito.");
            return false;
        }

        if (venta.getTotal() <= 0) {
            System.out.println("Error: El total de la venta debe ser mayor a cero.");
            return false;
        }

        // Llamamos al DAO que hace la transacción en la base de datos
        return ventaDAO.registrarVenta(venta, detalles);
    }
}