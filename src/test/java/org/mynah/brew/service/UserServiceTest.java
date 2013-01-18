package org.mynah.brew.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.security.NoSuchAlgorithmException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mynah.brew.model.User;
import org.mynah.brew.util.ConstantsTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(ConstantsTest.CONTEXT)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
    }

    @Test
    public void testVerifyPassword() throws NoSuchAlgorithmException {
        assertThat(userService.verifyPassword("", ""), is(false));
    }

    @Test
    public void testSave() throws NoSuchAlgorithmException {
        // TODO咋测试
        User user = new User();
        user.setUsername("dajue");
        user.setPassword("123456");
        // int id = userService.save(user);
        // System.out.println("id=" + id);
    }
}
