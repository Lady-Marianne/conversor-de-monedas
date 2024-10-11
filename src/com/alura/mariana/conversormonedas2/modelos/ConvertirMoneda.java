package com.alura.mariana.conversormonedas2.modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertirMoneda {

    public MonedaData convertirMoneda(String base_code, String target_code, double mount)
    {
        String miApiKey = "fa477dd4131f04ba5918ff0c";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + miApiKey
                + "/pair/" + base_code + "/" + target_code + "/" + mount);

        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(String.valueOf(direccion)))
                    .build();

            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), MonedaData.class);

            } catch (Exception e) {
                throw new RuntimeException("Moneda no encontrada.");
            }
        }

    }
}
