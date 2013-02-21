package org.mynah.brew.bind;

import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public final class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    /** Logger available to subclasses */
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(java.util.Date.class, new CustomDateEditor(new SimpleDateFormat(DATE_PATTERN), true));
    }
}
