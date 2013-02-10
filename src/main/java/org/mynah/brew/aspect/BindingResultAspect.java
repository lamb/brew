package org.mynah.brew.aspect;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

@Aspect
public class BindingResultAspect {

    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Around("execution(* org.mynah.brew.controller..*.*(..)) && args (..,result)")
    public Object valid(ProceedingJoinPoint pjp, BindingResult result) throws Throwable {
        logger.debug("result=" + result);
        Object value = null;
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            Map<String, Object> model = mav.getModel();
            model.put("result", result);
            mav.getView();//TODO 吃饭先...
            value = "result";
        } else {
            value = pjp.proceed();
        }
        return value;
    }

}
