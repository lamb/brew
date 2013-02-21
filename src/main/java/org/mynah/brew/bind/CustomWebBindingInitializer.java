package org.mynah.brew.bind;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class CustomWebBindingInitializer implements WebBindingInitializer {

    /** Logger available to subclasses */
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(new SimpleDateFormat(DATE_PATTERN), true));
    }

}
