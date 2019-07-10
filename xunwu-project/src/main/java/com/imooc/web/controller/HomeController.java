package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Jian Hua
 * @date: 2019/6/26 23:44
 **/
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/403")
    public String accessError() {
        return "403";
    }

    @GetMapping("/404")
    public String notFountPage() {
        return "404";
    }

    @GetMapping("/500")
    public String internalError() {
        return "500";
    }

    @GetMapping("/logout/page")
    public String logout() {
        return "logout";
    }
}
