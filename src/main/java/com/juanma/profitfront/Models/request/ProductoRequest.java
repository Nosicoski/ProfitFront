/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanma.profitfront.Models.request;



public class ProductoRequest {
    private String codigo;
    private String nombre;
    private String descripcion;
    private Boolean disponible;
    private Integer stock;
    private String proveedor;
    private Double precioCompra;
    private Double precioVenta;
    private CategoriaRequest categoria; 

    public ProductoRequest() {}

    public ProductoRequest(String codigo, String nombre, String descripcion, 
                          Boolean disponible, Integer stock, String proveedor, 
                          Double precioCompra, Double precioVenta, CategoriaRequest categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.stock = stock;
        this.proveedor = proveedor;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
    }

    
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
    
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    
    public String getProveedor() { return proveedor; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }
    
    public Double getPrecioCompra() { return precioCompra; }
    public void setPrecioCompra(Double precioCompra) { this.precioCompra = precioCompra; }
    
    public Double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(Double precioVenta) { this.precioVenta = precioVenta; }
    
    public CategoriaRequest getCategoria() { return categoria; }
    public void setCategoria(CategoriaRequest categoria) { this.categoria = categoria; }
}