package org.mynah.brew.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.mynah.brew.util.Constants;

public class SigninInterceptor extends HandlerInterceptorAdapter {

    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug(request.getServletPath() + "preHandle-----SigninInterceptor Start!");
        boolean flag = true;
        HttpSession session = request.getSession();
        Object object = session.getAttribute(Constants.SESSION_USER);
        if (null == object) {
            flag = false;
            response.sendRedirect("signin/callback?callback=" + URLEncoder.encode(request.getServletPath(), Constants.ENCODING));
        }
        return flag;
    }

}
