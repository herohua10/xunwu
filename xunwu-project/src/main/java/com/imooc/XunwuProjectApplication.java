package com.imooc;

import com.imooc.base.ApiResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class XunwuProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(XunwuProjectApplication.class, args);
    }

    @RequestMapping(value = "/admin/test1", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse test(@RequestBody RequestTest req) {

        return ApiResponse.ofStatus(ApiResponse.Status.SUCCESS);
    }

}
