package org.mynah.brew.util;

import javax.servlet.http.Cookie;

public final class CookieUtil {

    private CookieUtil() {
    }

    public static String getValue(Cookie[] cookies, String name) {
        String value = null;
        if (cookies != null && name != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }
    
    public static Cookie newCookie(String username, String password) {
        Cookie cookie = new Cookie(Constants.COOKIE_SU, username + ":" + password);
        cookie.setPath("/");
        cookie.setMaxAge(Integer.MAX_VALUE);
        return cookie;
    }

}
