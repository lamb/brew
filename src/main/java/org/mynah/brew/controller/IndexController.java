package org.mynah.brew.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mynah.brew.service.UserService;
import org.mynah.brew.util.Constants;
import org.mynah.brew.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        String view = "index/page";
        HttpSession session = request.getSession();
        Object object = session.getAttribute(Constants.SESSION_USER);
        if (null == object) {
            Cookie[] cookies = request.getCookies();
            String su = CookieUtil.getValue(cookies, Constants.COOKIE_SU);
            if (null != su) {
                String[] values = su.split(":");
                String username = values[0];
                String password = values[1];
                if (userService.verifyPassword(username, password)) {
                    session.setAttribute(Constants.SESSION_USER, userService.get(username));
                    view = "redirect:/home";
                }
            }
        }
        return view;
    }

}
