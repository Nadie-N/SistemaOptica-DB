/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Luna;

/**
 *
 * @author nekom
 */
public interface LunaDAO {
    boolean registrar(Luna luna);
    Luna buscarPorId(int idProcucto);
    List<Luna> listar();
    boolean actualizar(Luna luna);
    boolean eliminar(int idProducto);
}
