package com.alura.mariana.conversormonedas.modelos;

public record MonedaData(
        String base_code,
        String target_code,
        double conversion_rate,
        double conversion_result,
        String time_last_update_utc
) {
    public String formatoConsulta() {
        return String.format("%s son %.2f %s.\nHora de la última actualización: %s",
                base_code, conversion_result, target_code, time_last_update_utc);
    }
}
