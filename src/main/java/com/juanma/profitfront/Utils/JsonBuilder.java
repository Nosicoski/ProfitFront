/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanma.profitfront.Utils;


public class JsonBuilder {
    public static String buildLoginJson(String nombreUsuario, String password) {
        return "{"
                + "\"nombreUsuario\":\"" + escapeJson(nombreUsuario) + "\","
                + "\"password\":\"" + escapeJson(password) + "\""
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