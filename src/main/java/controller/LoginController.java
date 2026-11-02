package controller;

import dao.UsuarioDAO;
import impl.dao.UsuarioDAOImpl;
import model.Usuario;

public class LoginController {
    
    private UsuarioDAO usuarioDAO;

    public LoginController() {
        // Instanciamos la implementación, pero guardamos en la interfaz
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    public Usuario iniciarSesion(String usuario, String contrasena) {
        if (usuario == null || usuario.trim().isEmpty() || 
            contrasena == null || contrasena.trim().isEmpty()) {
            return null;
        }
        
        // CORREGIDO: Llamamos a iniciarSesion en lugar de validarLogin
        return usuarioDAO.iniciarSesion(usuario.trim(), contrasena.trim());
    }
}