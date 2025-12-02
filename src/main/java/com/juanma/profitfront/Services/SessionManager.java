/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanma.profitfront.Services;


import com.juanma.profitfront.Models.response.LoginResponse;

public class SessionManager {
    private static String authToken;
    private static LoginResponse.UsuarioResponse currentUser;

    public static void login(String token, LoginResponse.UsuarioResponse user) {
        authToken = token;
        currentUser = user;
        ApiClient.setAuthToken(token);
    }

    public static void logout() {
        authToken = null;
        currentUser = null;
        ApiClient.setAuthToken(null);
    }

    public static boolean isLoggedIn() {
        return authToken != null && !authToken.isEmpty();
    }

    public static String getAuthToken() {
        return authToken;
    }

    public static LoginResponse.UsuarioResponse getCurrentUser() {
        return currentUser;
    }
}