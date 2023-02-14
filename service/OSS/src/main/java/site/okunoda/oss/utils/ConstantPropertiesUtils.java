package site.okunoda.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Okunoda
 * @date 2023年02月12日15:20
 */


@Component
public class ConstantPropertiesUtils implements InitializingBean {
    /**
     * 通过 @Value 注解读取配置文件中的内容
     * 自动注入
     */
    @Value("${aliyun.oss.file.endpoint}")
    private String endPoint;

    @Value("${aliyun.oss.file.keyid}")
    private String keyId;

    @Value("${aliyun.oss.file.keysecret}")
    private String keySecret;

    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;


    /**
     * 执行过程是，首先会自动读取配置文件中的值注入到上述文件中，之后执行afterPropertiesSet方法
     */
    //定义静态变量提供给外部调用
    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;


    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT=endPoint;
        KEY_ID=keyId;
        KEY_SECRET=keySecret;
        BUCKET_NAME=bucketName;
    }
}
