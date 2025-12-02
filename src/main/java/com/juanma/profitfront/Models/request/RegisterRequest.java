package com.juanma.profitfront.Models.request;


public class RegisterRequest {
    private String nombreUsuario;
    private String password;
    private String nombre;
    private String apellido;
    private Rol rol;

  
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public static class Rol {
        private Long id;
        private String nombre;

        public Rol() {}

        public Rol(Long id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
    }
}