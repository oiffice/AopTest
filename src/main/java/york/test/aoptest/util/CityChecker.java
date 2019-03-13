package york.test.aoptest.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class CityChecker {

    private static CityChecker cityChecker = null;
    private List<String> cities = new ArrayList<>();

    private CityChecker() {
        cities.add("基隆市");
        cities.add("台北市");
        cities.add("新北市");
        cities.add("桃園縣");
        cities.add("新竹市");
        cities.add("新竹縣");
        cities.add("苗栗縣");
        cities.add("台中市");
        cities.add("彰化縣");
        cities.add("南投縣");
        cities.add("雲林縣");
        cities.add("嘉義市");
        cities.add("嘉義縣");
        cities.add("台南市");
        cities.add("高雄市");
        cities.add("屏東縣");
        cities.add("台東縣");
        cities.add("花蓮縣");
        cities.add("宜蘭縣");
        cities.add("澎湖縣");
        cities.add("金門縣");
        cities.add("連江縣");
    }

    public static CityChecker getInstance() {
        if (Objects.isNull(cityChecker)) {
            cityChecker = new CityChecker();
        }

        return cityChecker;
    }

    public boolean isValidateCity(String cityName) {
        return cities.contains(cityName);
    }
}
