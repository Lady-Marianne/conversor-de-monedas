package com.alura.mariana.conversormonedas.modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertirMoneda {
    private static final String MI_API_KEY = "fa477dd4131f04ba5918ff0c";

    public MonedaMasMonto convertirMoneda(String baseCode, String targetCode, double mount)
    {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + MI_API_KEY
                + "/pair/" + baseCode + "/" + targetCode + "/" + mount);

        HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(String.valueOf(direccion)))
                    .build();

            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), MonedaMasMonto.class);

            } catch (Exception e) {
                throw new RuntimeException("Moneda no encontrada.");
            }
        }

    }

