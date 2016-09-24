/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.prendas.model;

/**
 *
 * @author Sofía 
 */
public class Prenda {
   private int idPrenda;
   private String descripcion;
   private String stand;
   private String color;
   private int precio;

   public Prenda() {
        this(0,"","","",0);
    }

    public Prenda(int idPrenda, String descripcion, String stand, String color, int precio) {
        this.idPrenda = idPrenda;
        this.descripcion = descripcion;
        this.stand = stand;
        this.color = color;
        this.precio = precio;
    }

    public int getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

 

    @Override
    public String toString() {
        return "Prenda{" + "idPrenda=" + idPrenda + ", descripcion=" + descripcion + ", stand=" + stand + ", color=" + color + ", precio=" + precio + '}';
    }

   
}
