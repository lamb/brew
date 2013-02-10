package org.mynah.brew.controller;

import java.security.NoSuchAlgorithmException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.mynah.brew.model.User;
import org.mynah.brew.service.UserService;
import org.mynah.brew.util.Constants;
import org.mynah.brew.util.CryptoUtil;

@Controller
public class SignController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
        return "signin/page";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@Valid User user, BindException result, HttpServletResponse response) throws NoSuchAlgorithmException {
        user.setPassword(CryptoUtil.digest(user.getPassword(), userService.getSalt(user.getUsername())));
        if (userService.verifyPassword(user.getUsername(), user.getPassword())) {
            Cookie cookie = new Cookie(Constants.COOKIE_SU, user.getUsername() + ":" + user.getPassword());
            cookie.setPath("/");
            cookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie);
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/cookie", method = RequestMethod.GET)
    @ResponseBody
    public String cookie(@CookieValue(value = "SU", required = false) String su) {
        return su;
    }

}
