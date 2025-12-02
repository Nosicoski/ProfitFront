package com.juanma.profitfront.Models.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    private String token;
    private UsuarioResponse usuario;
    private String mensaje;

    
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    
    public UsuarioResponse getUsuario() { return usuario; }
    public void setUsuario(UsuarioResponse usuario) { this.usuario = usuario; }
    
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public static class UsuarioResponse {
        private Long id;
        
        @SerializedName("nombreUsuario")
        private String nombreUsuario;
        
        private String nombre;
        private String apellido;
        private String rol;

       
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        
        public String getNombreUsuario() { return nombreUsuario; }
        public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
        
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        
        public String getApellido() { return apellido; }
        public void setApellido(String apellido) { this.apellido = apellido; }
        
        public String getRol() { return rol; }
        public void setRol(String rol) { this.rol = rol; }

        public String getNombreCompleto() {
            return nombre + " " + apellido;
        }
    }
}