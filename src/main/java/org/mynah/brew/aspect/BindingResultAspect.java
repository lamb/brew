package org.mynah.brew.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.validation.BindingResult;

@Aspect
public class BindingResultAspect {

    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Around("execution(* org.mynah.brew.controller..*.*(..)) && args (..,result)")
    public String valid(ProceedingJoinPoint pjp, BindingResult result) throws Throwable {
        logger.debug("result=" + result);
        String value = null;
        if (result.hasErrors()) {
            value = "result";
        } else {
            value = (String) pjp.proceed();
        }
        return value;
    }

}
