/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Venta;

/**
 *
 * @author nekom
 */
public interface VentaDAO {
    boolean registrar(Venta venta);
    Venta buscarPorId(int idVenta);
    List<Venta> listar();
    boolean actualizar(Venta venta);
    boolean eliminar(int idVenta);
}
