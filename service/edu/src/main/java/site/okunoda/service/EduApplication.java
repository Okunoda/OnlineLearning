package site.okunoda.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author Okunoda
 * @date 2023年01月17日16:09
 */

@SpringBootApplication
@ComponentScan(basePackages = {"site.okunoda"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);

    }
}
