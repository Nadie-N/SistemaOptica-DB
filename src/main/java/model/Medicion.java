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
public class Medicion {
    
    private int idMedicion;
    private int idCliente;
    private Date fechaMedicion;
    private double esfera;
    private double cilindro;
    private int eje;
    private double adicion;
    private String observaciones;
    
    public Medicion(){
    }
    
    public Medicion(int idMedicion, int idCliente, Date fechaMedicion, 
        double esfera, double cilindro, int eje, double adicion, String observaciones){
        this.idMedicion = idMedicion;
        this.idCliente = idCliente;
        this.fechaMedicion = fechaMedicion;
        this.esfera = esfera;
        this.cilindro = cilindro;
        this.eje = eje;
        this.adicion = adicion;
        this.observaciones = observaciones;
        
    }
    
    public int getIdMedicion(){
        return idMedicion;
    }
    
    public void setIdMedicion(int idMedicion){
        this.idMedicion = idMedicion;
    }
    
    public int getIdCliente(){
        return idCliente;
    }
    
    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }
    
    public Date getFechaMedicion(){
        return fechaMedicion;
    }
    
    public void setFechaMedicion(Date fechaMedicion){
        this.fechaMedicion = fechaMedicion;
    }
    
    public double getEsfera(){
        return esfera;
    }
    
    public void setEsfera(double esfera){
        this.esfera = esfera;
    }
    
    public double getCilindro(){
        return cilindro;
    }
    
    public void setCilindro(double cilindro){
        this.cilindro = cilindro;
    }
    
    public int getEje(){
        return eje;
    }
    
    public void setEje(int eje){
        this.eje = eje;
    }
    
    public double getAdicion(){
        return adicion;
    }
    
    public void setAdicion(double adicion){
        this.adicion = adicion;
    }
    
    public String getObservaciones(){
        return observaciones;
    }
    
    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
