package york.test.aoptest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import york.test.aoptest.interfaces.NotChecking;
import york.test.aoptest.service.WeatherService;
import york.test.aoptest.bean.ResultBean;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/temp/today")
    public ResultBean fetchTodayTemperature(@RequestParam String city) {
        return new ResultBean<>(weatherService.fetchTodayTemperature(city));
    }

    @NotChecking
    @RequestMapping("/temp/seven_days")
    public ResultBean fetchSevenDaysTemperature(@RequestParam String city) {
        return new ResultBean<>(weatherService.fetchSevenDaysTemperature(city));
    }
}
