/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Accesorio;

/**
 *
 * @author nekom
 */
public interface AccesorioDAO {
    boolean registrar(Accesorio accesorio);
    Accesorio buscarPorId(int idProducto);
    List<Accesorio> listar();
    boolean actualizar(Accesorio accesorio);
    boolean eliminar(int idProducto);
}
