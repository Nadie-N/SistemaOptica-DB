/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Medicion;

/**
 *
 * @author nekom
 */
public interface MedicionDAO {
    boolean registrar(Medicion medicion);
    Medicion buscarPorId(int idMedicion);
    List<Medicion> listarPorCliente(int idCliente);
    boolean actualizar(Medicion medicion);
    boolean eliminar(int idMedicion);
}
