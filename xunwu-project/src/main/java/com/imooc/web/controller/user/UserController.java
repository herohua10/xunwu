package com.imooc.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Jian Hua
 * @date: 2019/6/28 21:47
 **/
@Controller
public class UserController {

    @GetMapping("/user/center")
    public String adminCenterPage() {
        return "user/center";
    }

    @GetMapping("/user/login")
    public String welcomePage() {
        return "user/login";
    }
}
