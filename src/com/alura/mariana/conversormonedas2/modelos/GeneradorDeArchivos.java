package com.alura.mariana.conversormonedas2.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivos {
    public void guardarJson(List<MonedaData> monedaData, Object listaConsultas) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("consultas.json");
        escritura.write(gson.toJson(listaConsultas));
        escritura.close();
    }
}