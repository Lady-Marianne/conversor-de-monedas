package com.alura.mariana.conversormonedas.principal;

import com.alura.mariana.conversormonedas.service.ConvertirMoneda;
import com.alura.mariana.conversormonedas.service.FormatearTiempo;
import com.alura.mariana.conversormonedas.service.GeneradorDeArchivos;
import com.alura.mariana.conversormonedas.modelos.MonedaMasMonto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static String obtenerMoneda(int opcion) {
        return switch (opcion) {
            case 1 -> "ARS"; // Peso Argentino
            case 2 -> "USD"; // Dólar
            case 3 -> "EUR"; // Euro
            case 4 -> "BRL"; // Real
            case 5 -> "PEN"; // Sol
            case 6 -> "COP"; // Peso Colombiano
            case 7 -> "MXN"; // Peso Mexicano
            case 0 -> "Salir";
            default -> throw new IllegalArgumentException("Por favor, ingrese una opción válida.");
        };
    }

    public static void main(String[] args) {
        System.out.println("""
                \n***************************************
                ********* CONVERSOR DE MONEDAS ********
                ***************************************
                """);

        Scanner lectura = new Scanner(System.in);
        ConvertirMoneda convertir = new ConvertirMoneda();
        List<MonedaMasMonto> listaConsultas = new ArrayList<>();
        GeneradorDeArchivos generador = new GeneradorDeArchivos();

        while (true) {
            try {
                System.out.println("""
                    *************************************************
                    Elija la moneda de origen:
                    1) Peso Argentino
                    2) Dólar
                    3) Euro
                    4) Real
                    5) Sol
                    6) Peso Colombiano
                    7) Peso Mexicano
                    0) Salir
                    *************************************************
                    """);

                var opcionMonedaOrigen = lectura.nextInt();
                String baseCode = obtenerMoneda(opcionMonedaOrigen);
                if (baseCode.equals("Salir")) {
                    System.out.println("Finalizando aplicación.");
                    break;
                }

                System.out.println("""
                    *************************************************
                    Elija la moneda de destino:
                    1) Peso Argentino
                    2) Dólar
                    3) Euro
                    4) Real
                    5) Sol
                    6) Peso Colombiano
                    7) Peso Mexicano
                    0) Salir
                    *************************************************
                    """);

                var opcionMonedaDestino = lectura.nextInt();
                String targetCode = obtenerMoneda(opcionMonedaDestino);

                if (targetCode.equals("Salir")) {
                    System.out.println("Finalizando aplicación.");
                    break;
                }

                System.out.println("Ingrese el monto a convertir:");
                double mount = lectura.nextDouble();

                MonedaMasMonto monedaMasMonto = convertir.convertirMoneda(baseCode, targetCode, mount);
                listaConsultas.add(monedaMasMonto);
                System.out.println(monedaMasMonto.getMount() + " " + monedaMasMonto.getBaseCode() +
                        " son " + monedaMasMonto.getConversionResult() + " " +
                        monedaMasMonto.getTargetCode());
//                System.out.println("Hora de la última actualización: " + monedaMasMonto.getTimeLastUpdateUtc()
//                + "\n");
                System.out.println("Hora de la última actualización: " +
                        FormatearTiempo.formatearTiempo(monedaMasMonto.getTimeLastUpdateUtc())
                + " hs.\n");


            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese una opción válida.\n");
                lectura.nextLine();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            generador.guardarJson(listaConsultas);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
