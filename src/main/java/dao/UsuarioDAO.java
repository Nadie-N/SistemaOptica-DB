/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Usuario;

/**
 *
 * @author nekom
 */
public interface UsuarioDAO {
    boolean registrar(Usuario usuario);
    Usuario iniciarSesion(String usuario, String contrasena);
    List<Usuario> listar();
    boolean actualizar(Usuario usuario);
    boolean eliminar(int idUsuario);
}
