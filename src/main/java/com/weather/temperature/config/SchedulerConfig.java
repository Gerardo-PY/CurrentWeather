package com.weather.temperature.config;

import com.weather.temperature.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {
    @Autowired
    private WeatherService weatherService;

    // 10 minutes is 600000 milliseconds
    // 15 minutes is 900000 milliseconds
    // 30 minutes is 1800000 milliseconds
    @Scheduled(fixedRate = 600000)
    public void fetchTemperatureAtInterval() {
        for (String codigo : weatherService.getAllCachedCodigos()) {
            weatherService.fetchTemperature(codigo);
        }
    }
}
