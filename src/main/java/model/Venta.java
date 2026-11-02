/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author nekom
 */
public class Venta {
    
    private int idVenta;
    private int idCliente;
    private int idVendedor;
    private int idMedicion;
    private int idAro;
    private Date fechaVenta;
    private double subtotal;
    private double impuesto;
    private double total;
    
    public Venta(){
        
    }
    
    public Venta(int idVenta, int idCliente, int idVendedor,
                int idMedicion, int idAro, Date fechaVenta, double subtotal,
                double impuesto, double total){
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.idMedicion = idMedicion;
        this.idAro = idAro;
        this.fechaVenta = fechaVenta;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
    }
    
    public int getIdVenta(){
        return idVenta;
    }
    
    public void setIdVenta(int idVenta){
        this.idVenta = idVenta;
    }
    
    public int getIdCliente(){
        return idCliente;
    }
    
    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }
    
    public int getIdVendedor(){
        return idVendedor;
    }
    
    public void setIdVendedor(int idVendedor){
        this.idVendedor = idVendedor;
    }
    
    public int getIdMedicion(){
        return idMedicion;
    }
    
    public void setIdMedicion(int idMedicion){
        this.idMedicion = idMedicion;
    }

    // --- ESTOS ERAN LOS QUE FALTABAN ---
    public int getIdAro(){
        return idAro;
    }
    
    public void setIdAro(int idAro){
        this.idAro = idAro;
    }
    // -----------------------------------

    public Date getFechaVenta(){
        return fechaVenta;
    }
    
    public void setFechaVenta(Date fechaVenta){
        this.fechaVenta = fechaVenta;
    }
    
    public double getSubtotal(){
        return subtotal;
    }
    
    public void setSubtotal(double subtotal){
        this.subtotal = subtotal;
    }
    
    public double getImpuesto(){
        return impuesto;
    }
    
    public void setImpuesto(double impuesto){
        this.impuesto = impuesto;
    }
    
    public double getTotal(){
        return total;
    }
    
    public void setTotal(double total){
        this.total = total;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}