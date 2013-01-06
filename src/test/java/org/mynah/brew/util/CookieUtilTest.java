package org.mynah.brew.util;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import javax.servlet.http.Cookie;
import org.junit.Test;
import org.mynah.brew.util.Constants;
import org.mynah.brew.util.CookieUtil;

public class CookieUtilTest {

    @Test
    public void testGetValue() {
        Cookie[] cookies = new Cookie[Constants.HUNDRED];
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = new Cookie("c" + i, "c" + i);
            cookies[i] = cookie;
        }
        assertThat(CookieUtil.getValue(cookies, "c3"), is("c3"));
        assertNull(CookieUtil.getValue(cookies, null));
        assertNull(CookieUtil.getValue(null, "c3"));
    }

}
