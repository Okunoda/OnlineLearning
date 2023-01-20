package site.okunoda.service_base.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Okunoda
 * @date 2023年01月20日23:42
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OLException extends RuntimeException{
    //状态码
    private int code;
    //异常信息
    private String msg;
}
