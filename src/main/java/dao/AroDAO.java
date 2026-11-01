/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Aro;

/**
 *
 * @author nekom
 */
public interface AroDAO {
    boolean registrar(Aro aro);
    Aro buscarPorId(int idProducto);
    List<Aro> listar();
    boolean actualizar(Aro aro);
    boolean eliminar(int idProducto);
}
