package com.alura.mariana.conversormonedas.modelos;

import com.google.gson.annotations.SerializedName;
public record MonedaData(
        @SerializedName("base_code") String baseCode,
        @SerializedName("target_code") String targetCode,
        @SerializedName("conversion_rate") Double conversionRate,
        @SerializedName("conversion_result") Double conversionResult,
        @SerializedName("time_last_update_utc") String timeLastUpdateUtc
) {

}
