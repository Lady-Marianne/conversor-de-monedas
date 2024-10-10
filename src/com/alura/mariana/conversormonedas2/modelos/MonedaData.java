package com.alura.mariana.conversormonedas2.modelos;

public record MonedaData(
        String base_code,
        String target_code,
        double mount,
        double conversion_rate,
        double conversion_result,
        String time_last_update_utc
) {
    public String formatoConsulta() {
        return String.format("%.2f %s son %.2f %s.\nHora de la última actualización: %s",
                mount, base_code, conversion_result, target_code, time_last_update_utc);
    }
}
