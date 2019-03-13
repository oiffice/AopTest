package york.test.aoptest.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import york.test.aoptest.util.CityChecker;

@Component
@Configuration
public class CityCheckerBean {

    @Bean
    public CityChecker cityChecker() {
        return CityChecker.getInstance();
    }
}
