package com.imooc.base;

import com.imooc.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author: Jian Hua
 * @date: 2019/7/1 22:26
 **/
public class LoginUserUtil {

    public static User load() {

        Object principal = (User) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        if (principal != null && principal instanceof User) {
            return (User) principal;
        }
        return null;
    }

    public static Long getLoginUserId() {
        User user = load();
        if (user == null) {
            return -1L;
        }

        return user.getId();
    }
}
