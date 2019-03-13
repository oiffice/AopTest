package york.test.aoptest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerAop {

    @Pointcut(value = "execution(* york.test.aoptest.controller.WeatherController.*(..))")
    public void inputValidate() {}

    @Around("inputValidate()")
    public void checkCityName(ProceedingJoinPoint pj) {

        Object[] objects = pj.getArgs();


        for (Object o : objects) {


        }

    }
}
