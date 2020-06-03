package com.xy.express.web.login;

import com.xy.express.web.Res.WebResBean;
import com.xy.express.web.constant.SystemStatusEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther HHF
 * @create 2020-06-03 下午 3:29
 */
@RestController
public class LoginController {

    @RequestMapping("login")
    public WebResBean login(){
        return WebResBean.createResBean(SystemStatusEnum.E_20000);
    }

}
