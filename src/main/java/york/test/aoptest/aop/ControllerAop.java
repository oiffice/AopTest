package york.test.aoptest.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import york.test.aoptest.bean.ResultBean;
import york.test.aoptest.exception.InvalidateCityNameException;
import york.test.aoptest.util.CityEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
@Slf4j
public class ControllerAop {

    @Pointcut(value = "execution(* york.test.aoptest.controller.WeatherController.*(..)) && !@annotation(york.test.aoptest.interfaces.NotChecking)")
    public void inputValidate() {}

    @Around("inputValidate()")
    public ResultBean checkCityName(ProceedingJoinPoint pj) throws Exception {

        log.info("Method Call: {} {}", pj.getSignature().getDeclaringType(), pj.getSignature().getName());

        Object[] objects = pj.getArgs();
        ResultBean<?> resultBean;

        try {

            for (Object o : objects) {

                if(!EnumUtils.isValidEnum(CityEnum.class, (String) o)) {
                    throw new InvalidateCityNameException("Invalidate city name " + o);
                }
            }

            resultBean = (ResultBean<?>) pj.proceed();

        } catch (Throwable t) {

            log.error("Something wrong: {} error {}", pj.getSignature(), t.getMessage());

            resultBean = new ResultBean();
            resultBean.setCode(ResultBean.FAIL);
            resultBean.setMsg(t.getMessage());

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            request.setAttribute("resultBean", resultBean);
            request.setAttribute("exception", new InvalidateCityNameException(pj.getSignature() + t.getMessage()));
            request.getRequestDispatcher("/error/error00").forward(request, response);
        }

        return resultBean;
    }
}
