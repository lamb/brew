package org.mynah.brew.controller;

import java.security.NoSuchAlgorithmException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.mynah.brew.model.User;
import org.mynah.brew.service.UserService;
import org.mynah.brew.util.Constants;
import org.mynah.brew.util.CookieUtil;
import org.mynah.brew.util.CryptoUtil;

@Controller
public class SignController {

    /** Logger available to subclasses */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
        return "signin/page";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@Valid User user, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException {
        HttpSession session = request.getSession();
        user.setPassword(CryptoUtil.digest(user.getPassword(), userService.getSalt(user.getUsername())));
        String username = user.getUsername();
        String password = user.getPassword();
        if (userService.verifyPassword(username, password)) {
            session.setAttribute(Constants.SESSION_USER, userService.get(user.getUsername()));
            response.addCookie(CookieUtil.newCookie(username, password));
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/signout")
    public String signout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute(Constants.SESSION_USER);
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            cookies[i].setValue(null);
            cookies[i].setMaxAge(-1);
            response.addCookie(cookies[i]);
        }
        return "redirect:";
    }

    @RequestMapping(value = "/signin/callback", method = RequestMethod.GET)
    public String signin(@CookieValue("SU") String su, String callback, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException {
        logger.debug("callback=" + callback);
        HttpSession session = request.getSession();
        String[] values = su.split(":");
        String username = values[0];
        String password = values[1];
        if (userService.verifyPassword(username, password)) {
            session.setAttribute(Constants.SESSION_USER, userService.get(username));
            response.addCookie(CookieUtil.newCookie(username, password));
        }
        return "redirect:" + callback;
    }

    @RequestMapping(value = "/cookie", method = RequestMethod.GET)
    @ResponseBody
    public String cookie(@CookieValue(value = "SU", required = false) String su) {
        return su;
    }

}
