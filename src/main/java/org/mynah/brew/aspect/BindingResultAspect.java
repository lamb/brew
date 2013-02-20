package org.mynah.brew.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

@Aspect
public class BindingResultAspect {

    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Around("execution(* org.mynah.brew.controller..*.*(..)) && args (..,result)")
    public Object valid(ProceedingJoinPoint pjp, BindingResult result) throws Throwable {
        logger.debug("result.hasErrors()=" + result.hasErrors() + ":result=" + result);
        if (result.hasErrors()) {
            throw new BindException(result);
        } else {
            return pjp.proceed();
        }
    }

}
