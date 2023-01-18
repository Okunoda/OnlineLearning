package site.okunoda.service_base.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import site.okunoda.common_utils.R;

/**
 * @author Okunoda
 * @date 2023年01月18日23:41
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R error(Exception e){

        e.printStackTrace();
        return R.error().message("全局异常产生");
    }

}
