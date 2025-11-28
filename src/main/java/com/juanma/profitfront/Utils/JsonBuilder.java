package com.juanma.profitfront.Utils;

import com.juanma.profitfront.Models.RegisterRequest;

public class JsonBuilder {
    
    public static String buildLoginJson(String nombreUsuario, String password) {
        return "{"
                + "\"nombreUsuario\":\"" + escapeJson(nombreUsuario) + "\","
                + "\"password\":\"" + escapeJson(password) + "\""
                + "}";
    }
    
    public static String buildRegisterJson(RegisterRequest request) {
        return "{"
                + "\"nombreUsuario\":\"" + escapeJson(request.getNombreUsuario()) + "\","
                + "\"password\":\"" + escapeJson(request.getPassword()) + "\","
                + "\"nombre\":\"" + escapeJson(request.getNombre()) + "\","
                + "\"apellido\":\"" + escapeJson(request.getApellido()) + "\","
                + "\"rol\": {"
                + "\"id\": " + request.getRol().getId() + ","
                + "\"nombre\": \"" + escapeJson(request.getRol().getNombre()) + "\""
                + "}"
                + "}";
    }
    
    private static String escapeJson(String text) {
        if (text == null) return "";
        return text.replace("\\", "\\\\")
                  .replace("\"", "\\\"")
                  .replace("\b", "\\b")
                  .replace("\f", "\\f")
                  .replace("\n", "\\n")
                  .replace("\r", "\\r")
                  .replace("\t", "\\t");
    }
}