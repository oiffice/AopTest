package york.test.aoptest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import york.test.aoptest.bean.ResultBean;
import york.test.aoptest.util.CityChecker;

@Aspect
@Component
@Slf4j
public class ControllerAop {

    @Pointcut(value = "execution(* york.test.aoptest.controller.WeatherController.*(..)) && !@annotation(york.test.aoptest.interfaces.NotChecking)")
    public void inputValidate() {}

    @Around("inputValidate()")
    public ResultBean checkCityName(ProceedingJoinPoint pj) {


        log.info("Method Call: {} {}", pj.getSignature().getDeclaringType(), pj.getSignature().getName());

        Object[] objects = pj.getArgs();
        ResultBean<?> resultBean;

        try {

            for (Object o : objects) {

                if(!CityChecker.getInstance().isValidateCity((String) o)) {
                    throw new Throwable("Invalidate city name " + o);
                }

            }

            resultBean = (ResultBean<?>) pj.proceed();

        } catch (Throwable t) {
            resultBean = handleException(t, pj);
        }

        return resultBean;
    }

    private ResultBean handleException(Throwable throwable, ProceedingJoinPoint pj) {

        log.error("Something wrong: {} error {}", pj.getSignature(), throwable.getMessage());

        ResultBean resultBean = new ResultBean();
        resultBean.setCode(ResultBean.FAIL);
        resultBean.setMsg(throwable.getMessage());
        return resultBean;

    }
}
