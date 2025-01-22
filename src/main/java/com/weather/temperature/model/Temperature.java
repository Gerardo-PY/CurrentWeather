package com.weather.temperature.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Temperature {
    @JacksonXmlProperty(localName = "valorTemperatura")
    private String valorTemperatura;

    public Temperature(String valor) {
        this.valorTemperatura = valor;
    }
}
