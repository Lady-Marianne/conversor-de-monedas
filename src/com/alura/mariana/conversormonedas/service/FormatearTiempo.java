package com.alura.mariana.conversormonedas.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class FormatearTiempo {
    public static String formatearTiempo(String timeLastUpdateUtc) {
        DateTimeFormatter formatearEntrada = DateTimeFormatter.ofPattern
                ("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        LocalDateTime fechaHoraUtc = LocalDateTime.parse(timeLastUpdateUtc, formatearEntrada);

        // Convertir a la zona horaria del sistema local del usuario:

        ZonedDateTime fechaHoraLocal = fechaHoraUtc.atZone(ZoneId.of("UTC"))
                .withZoneSameInstant(ZoneId.systemDefault());

        // Formatear a un estilo amigable en español:

        DateTimeFormatter formatearSalida = new DateTimeFormatterBuilder()
                .appendPattern("dd 'de' MMMM 'de' yyyy 'a las' HH:mm 'hs.'")
                .toFormatter(new Locale("es", "AR"));

        return fechaHoraLocal.format(formatearSalida);
    }


}
