package york.test.aoptest.service;

import org.springframework.stereotype.Service;
import york.test.aoptest.dto.WeatherDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class WeatherService {

    public WeatherDTO fetchTodayTemperature(String cityName) {
        //TODO: request to cwb api

        return new WeatherDTO(cityName, new Date().toString(), "23", "16");
    }

    public List<WeatherDTO> fetchSevenDaysTemperature(String cityName) {
        //TODO: request to cwb api

        List<WeatherDTO> weatherDTOS = new ArrayList<>();
        int max = 23;
        int min = 16;

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);

        for (int i = 0; i < 7; i++) {

            max += i;
            min += i;

            weatherDTOS.add(new WeatherDTO(cityName, c.getTime().toString(), String.valueOf(max), String.valueOf(min)));
        }

        return weatherDTOS;

    }
}
