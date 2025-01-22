package com.weather.temperature.controller;

import com.weather.temperature.model.Temperature;
import com.weather.temperature.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    // 0000086233 Estación por defecto = Villarrica
    // 0000086218 Aeropuerto Internacional Silvio Pettirossi (Luque)
    // 0000086217 Centro Meteorológico Nacional (Asunción)
    @GetMapping(value = "/current-temperature", produces = MediaType.APPLICATION_XML_VALUE)
    public Temperature getTemperatureByCode(
            @RequestParam(name = "code", defaultValue = "0000086233") String code) {
        return weatherService.getTemperatureByCode(code);
    }
}
