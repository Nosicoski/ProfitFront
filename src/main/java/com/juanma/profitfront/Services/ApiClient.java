package com.juanma.profitfront.Services;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ApiClient {
    private static final String BASE_URL = "http://localhost:8080";
    private static final OkHttpClient client = new OkHttpClient();
    private static String jwtToken;

    public static void setAuthToken(String token) {
        jwtToken = token;
    }

    public static String get(String endpoint) {
        try {
            Request.Builder requestBuilder = new Request.Builder()
                    .url(BASE_URL + endpoint)
                    .get();

            if (jwtToken != null && !jwtToken.isEmpty()) {
                requestBuilder.addHeader("Authorization", "Bearer " + jwtToken);
            }

            Request request = requestBuilder.build();
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                System.out.println("Error HTTP: " + response.code());
                return null;
            }

            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String post(String endpoint, String jsonBody) {
        return post(endpoint, jsonBody, false);
    }

    public static String post(String endpoint, String jsonBody, boolean includeAuth) {
        try {
            RequestBody body = RequestBody.create(
                    jsonBody,
                    MediaType.parse("application/json; charset=utf-8")
            );

            Request.Builder requestBuilder = new Request.Builder()
                    .url(BASE_URL + endpoint)
                    .post(body)
                    .addHeader("Content-Type", "application/json");

            if (includeAuth && jwtToken != null && !jwtToken.isEmpty()) {
                requestBuilder.addHeader("Authorization", "Bearer " + jwtToken);
            }

            Request request = requestBuilder.build();
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                System.out.println("Error HTTP: " + response.code());
                // Leer el cuerpo del error para más detalles
                if (response.body() != null) {
                    String errorBody = response.body().string();
                    System.out.println("Error response: " + errorBody);
                }
                return null;
            }

            String respuesta = response.body().string();
            System.out.println("RESPUESTA DEL SERVIDOR: " + respuesta);
            return respuesta;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String put(String endpoint, String jsonBody) {
        return put(endpoint, jsonBody, true);
    }

    public static String put(String endpoint, String jsonBody, boolean includeAuth) {
        try {
            RequestBody body = RequestBody.create(
                    jsonBody,
                    MediaType.parse("application/json; charset=utf-8")
            );

            Request.Builder requestBuilder = new Request.Builder()
                    .url(BASE_URL + endpoint)
                    .put(body)
                    .addHeader("Content-Type", "application/json");

            if (includeAuth && jwtToken != null && !jwtToken.isEmpty()) {
                requestBuilder.addHeader("Authorization", "Bearer " + jwtToken);
            }

            Request request = requestBuilder.build();
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                System.out.println("Error HTTP: " + response.code());
                return null;
            }

            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String delete(String endpoint) {
        try {
            Request.Builder requestBuilder = new Request.Builder()
                    .url(BASE_URL + endpoint)
                    .delete();

            if (jwtToken != null && !jwtToken.isEmpty()) {
                requestBuilder.addHeader("Authorization", "Bearer " + jwtToken);
            }

            Request request = requestBuilder.build();
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                System.out.println("Error HTTP: " + response.code());
                return null;
            }

            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}