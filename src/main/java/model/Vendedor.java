/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

/**
 *
 * @author nekom
 */
public class Vendedor {
    private int idVendedor;
    private int idUsuario;
    private String nombre;
    private String apellido;
    
    public Vendedor(){
    }
    
    public Vendedor(int idVendedor, int idUsuario, String nombre, String apellido){
       this.idVendedor = idVendedor;
       this.idUsuario = idUsuario;
       this.nombre = nombre;
       this.apellido = apellido;
    }
    
    public int getIdVendedor(){
        return idVendedor;
    }
    
    public void setIdVendedor(int idVendedor){
        this.idVendedor = idVendedor;
    }
    
    public int getIdUsuario(){
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
