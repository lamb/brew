package org.mynah.brew.util;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mynah.brew.util.Constants;

public class ConstantsTest {

    public static final String CONTEXT = "classpath:mist-context.xml";
    public static final String SERVLET_CONTEXT = "classpath:mist-servlet-context.xml";
    public static final String WEB_ROOT = "src/main/webapp";

    @Test
    public void test() {
        // new Constants();
        assertEquals("Mist", Constants.PROJECT_NAME);
    }

}
