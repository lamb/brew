package org.mynah.brew.loader;

import org.mynah.brew.util.ConstantsTest;

public class WebContextLoader extends GenericWebContextLoader {

    public WebContextLoader() {
        super(ConstantsTest.WEB_ROOT, false);
    }

}
