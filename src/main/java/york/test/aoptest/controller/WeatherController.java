package york.test.aoptest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import york.test.aoptest.util.ResultBean;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @RequestMapping("/temp/today")
    public ResultBean fetchTodayTemperature(@RequestParam String city) {
        return new ResultBean();
    }

    @RequestMapping("/temp/seven_days")
    public ResultBean fetchSevenDaysTemperature(@RequestParam String city) {
        return new ResultBean();
    }
}
