package org.mynah.brew.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.validation.BindException;

@Aspect
public class BindingResultAspect {

    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    public static final String RESULT = "result";

    @Around("execution(* org.mynah.brew.controller..*.*(..)) && args (..,result)")
    public Object valid(ProceedingJoinPoint pjp, BindException result) throws Throwable {
        logger.debug("result=" + result);
        if (result.hasErrors()) {
            throw result;
        } else {
            return pjp.proceed();
        }
    }

}
