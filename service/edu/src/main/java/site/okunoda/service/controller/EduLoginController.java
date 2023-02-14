package site.okunoda.service.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.okunoda.common_utils.R;
import site.okunoda.service.entity.Courage;

/**
 * @author Okunoda
 * @date 2023年01月26日20:16
 */


@RestController
@RequestMapping("/service/user")
@CrossOrigin    //解决跨域问题
public class EduLoginController {

    @GetMapping("/login")
    public R login(){
        return R.success().data("token","admin");
    }


    @GetMapping("/info")
    public R info(){
        Courage.getName(1);
        return R.success().code(20000).data("roles","admin").data("name","admin").data("avatar","https://i.328888.xyz/2023/01/27/bqqso.jpeg");
    }


}
