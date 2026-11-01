/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

/**
 *
 * @author nekom
 */
public class Aro {
    private int idProducto;
    private String nombre;
    private String marca;
    private String material;
    private String forma;
    private double precio;
    private int stock;
    
    public Aro(){
    }
    
    public Aro(int idProducto, String nombre, String marca,
            String material, String forma, double precio, int stock){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.material = material;
        this.forma = forma;
        this.precio = precio;
        this.stock = stock;
    }
    
    public int getIdProducto(){
        return idProducto;
    }
    
    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getMaterial(){
        return material;
    }
    
    public String getForma(){
        return forma;
    }
    
    public void setForma(String forma){
        this.forma = forma;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public int getStock(){
        return stock;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
