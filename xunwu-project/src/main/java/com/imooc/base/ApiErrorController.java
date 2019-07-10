package com.imooc.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: Jian Hua
 * @date: 2019/6/27 22:16
 **/
@Controller
public class ApiErrorController implements ErrorController {

    /**
     * 自定义错误请求路径
     */
    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Autowired
    public ApiErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    /**
     * Web页面错误处理
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {

        int status = response.getStatus();
        switch(status) {
            case 403:
                return "403";
            case 404:
                return "403";
            case 500:
                return "500";
            default:
                return "index";
        }
    }

    /**
     * 除Web页面外的错误处理，比如Json/XML等
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ApiResponse errorApiHandler(HttpServletRequest request) {

        RequestAttributes requestAttributes = new ServletRequestAttributes(request);

        Map<String, Object> attrs = this.errorAttributes.getErrorAttributes(requestAttributes, false);

        int status = getStatus(request);

        String message = (String) attrs.getOrDefault("message", "error");

        return ApiResponse.ofMessage(status, message);
    }

    private int getStatus(HttpServletRequest request) {

        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (null != status) {
            return status;
        }

        return 500;
    }
}
