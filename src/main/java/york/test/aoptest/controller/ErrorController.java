package york.test.aoptest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import york.test.aoptest.bean.ResultBean;
import york.test.aoptest.exception.InvalidateCityNameException;

import javax.servlet.http.HttpServletRequest;

/**
 * 集中處理 controller 的例外
 */

@ControllerAdvice
@RequestMapping("/error")
@Slf4j
public class ErrorController {

    @ExceptionHandler(InvalidateCityNameException.class)
    @RequestMapping("/error00")
    @ResponseBody
    ResultBean exceptionHandler(HttpServletRequest httpservletrequest) {

        //TODO should pass by const parameters
        ResultBean resultBean = (ResultBean) httpservletrequest.getAttribute("resultBean");
        Exception e = (Exception) httpservletrequest.getAttribute("exception");

        if (e instanceof InvalidateCityNameException) {
            log.error("InvalidateCityNameException: {}", e.getMessage());
        } else {
            log.error("Exception: {}", e.getMessage());
        }

        return resultBean;

    }
}
