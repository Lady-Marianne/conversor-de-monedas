package com.alura.mariana.conversormonedas.modelos;

import com.alura.mariana.conversormonedas.service.FormatearTiempo;

public class MonedaMasMonto {
    private String baseCode;
    private String targetCode;
    private Double mount;
    private Double conversionRate;
    private Double conversionResult;
    private String timeLastUpdateUtc;
    private String timeLastUpdateEspanol;

    public MonedaMasMonto(MonedaData monedaData) {
        this.baseCode = monedaData.baseCode();
        this.targetCode = monedaData.targetCode();
        this.conversionRate = monedaData.conversionRate();
        this.conversionResult = monedaData.conversionResult();
        this.timeLastUpdateUtc = monedaData.timeLastUpdateUtc();
        this.timeLastUpdateEspanol = FormatearTiempo.formatearTiempo(monedaData.timeLastUpdateUtc());
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(double conversionResult) {
        this.conversionResult = conversionResult;
    }

    public String getTimeLastUpdateUtc() {
        return timeLastUpdateUtc;
    }

    public void setTimeLastUpdateUtc(String timeLastUpdateUtc) {
        this.timeLastUpdateUtc = timeLastUpdateUtc;
    }

    public String getTimeLastUpdateEspanol() {
        return timeLastUpdateEspanol;
    }

    public void setTimeLastUpdateEspanol(String timeLastUpdateEspanol) {
        this.timeLastUpdateEspanol = timeLastUpdateEspanol;
    }

    public double getMount() {
        return mount;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }
}
