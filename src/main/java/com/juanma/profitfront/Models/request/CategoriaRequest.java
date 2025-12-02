/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanma.profitfront.Models.request;



public class CategoriaRequest {
    private Long categoriaId;

    public CategoriaRequest() {}

    public CategoriaRequest(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
}