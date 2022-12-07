
package com.emergentes.modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Venta {
    private int id ;
    private String factura;
    private int cantidad ;
    private float precio;
    private Date fecha;
    private String descripcion;
    private int producto_id;
    private int cliente_id;  
    
     private String producto;
    private String cliente;
 

    
    public Venta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

 
    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", factura=" + factura + ", cantidad=" + cantidad + ", precio=" + precio + ", fecha=" + fecha + ", descripcion=" + descripcion + ", producto_id=" + producto_id + ", cliente_id=" + cliente_id + ", cliente=" + cliente + ", producto=" + producto + '}';
    }
  
    public static void cargarVentasDiaEnLista(ArrayList<Venta> lista, Date fecha){
        
        
    }
    
    
    
    
}
