package site.okunoda.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Okunoda
 * @date 2023年02月12日14:48
 */

//将数据库的类不加载进来，因为上传头像功能不需要数据库
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"site.okunoda"})

public class OSSApplication {
    public static void main(String[] args) {
        SpringApplication.run(OSSApplication.class,args);
    }
}
