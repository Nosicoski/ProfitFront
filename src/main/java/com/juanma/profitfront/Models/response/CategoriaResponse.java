/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanma.profitfront.Models.response;



import com.google.gson.annotations.SerializedName;

public class CategoriaResponse {
    @SerializedName("categoriaId")
    private Long categoriaId;
    
    @SerializedName("nombre")
    private String nombre;
    
    @SerializedName("descripcion")
    private String descripcion;
    
    @SerializedName("activa")
    private Boolean activa;
    
   
    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }
}