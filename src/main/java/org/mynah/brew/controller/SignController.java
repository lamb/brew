package org.mynah.brew.controller;

import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;
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
    public String signin(@Valid User user, BindingResult result, HttpServletRequest request) throws NoSuchAlgorithmException {
        HttpSession session = request.getSession();
        user.setPassword(CryptoUtil.digest(user.getPassword(), userService.getSalt(user.getUsername())));
        String username = user.getUsername();
        String password = user.getPassword();
        if (userService.verifyPassword(username, password)) {
            session.setAttribute(Constants.SESSION_USER, userService.get(user.getUsername()));
            return "redirect:/home";
        } else {
            return "redirect:/signin";
        }
    }

    @RequestMapping(value = "/signout")
    public String signout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(Constants.SESSION_USER);
        return "redirect:/";
    }

    @RequestMapping(value = "/cookie", method = RequestMethod.GET)
    @ResponseBody
    public String cookie(@CookieValue(value = "SU", required = false) String su) {
        return su;
    }

}
