package site.okunoda.service_base.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import site.okunoda.common_utils.R;

/**
 * @author Okunoda
 * @date 2023年01月18日23:41
 */

@ControllerAdvice
//添加这个注解，就可以使用 log类的静态方法，将异常信息写入对应级别的日志文件中
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R error(Exception e){

        e.printStackTrace();
        return R.error().message("全局异常产生");
    }

    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("产生了算术异常");
    }

    //对于这类自定义异常，在需要使用的方法中需要手动try-catch然后throw 扔一个 new出来的自定义的异常对象
    @ResponseBody
    @ExceptionHandler(OLException.class)
    public R error(OLException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}
