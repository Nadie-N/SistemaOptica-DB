/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author nekom
 */
public interface ClienteDAO {
    boolean registrar(Cliente cliente);
    Cliente buscarPorId(int idCliente);
    List<Cliente> listar();
    boolean actualizar(Cliente cliente);
    boolean eliminar(int idCliente);
}
