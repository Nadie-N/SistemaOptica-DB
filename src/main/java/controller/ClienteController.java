package controller;

import impl.dao.ClienteDAOImpl;
import impl.dao.MedicionDAOImpl;
import model.Cliente;
import model.Medicion;
import java.util.List;

public class ClienteController {
    
    private ClienteDAOImpl clienteDAO;
    private MedicionDAOImpl medicionDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAOImpl();
        this.medicionDAO = new MedicionDAOImpl();
    }

    /**
     * Registra un nuevo cliente en la base de datos.
     */
    public String registrarCliente(Cliente c) {
        // Validaciones básicas de negocio
        if (c.getNombre() == null || c.getNombre().trim().isEmpty()) {
            return "El nombre es obligatorio.";
        }
        if (c.getDni() == null || c.getDni().trim().isEmpty()) {
            return "El DNI es obligatorio.";
        }
        
        boolean exito = clienteDAO.registrar(c);
        return exito ? "Cliente registrado con éxito." : "Error al conectar con la base de datos.";
    }

    /**
     * Obtiene el historial de mediciones de un cliente específico.
     * Se usa en la vista "HistorialMedicionFrame".
     */
    public List<Medicion> obtenerHistorialMediciones(int idCliente) {
        if (idCliente <= 0) {
            return null;
        }
        return medicionDAO.listarPorCliente(idCliente);
    }
    
    /**
     * Busca un cliente por su ID (útil cuando el vendedor lo necesita para una venta)
     */
    public Cliente buscarCliente(int idCliente) {
        return clienteDAO.buscarPorId(idCliente);
    }
}