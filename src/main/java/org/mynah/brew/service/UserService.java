package org.mynah.brew.service;

import java.security.NoSuchAlgorithmException;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.mynah.brew.model.User;
import org.mynah.brew.repository.IUserRepository;
import org.mynah.brew.util.Constants;
import org.mynah.brew.util.CryptoUtil;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Transactional(readOnly = true)
    public boolean verifyPassword(String username, String password) {
        boolean flag = false;
        String verify = userRepository.queryPassword(username);
        if (null != verify && null != password) {
            if (password.equals(verify)) {
                flag = true;
            }
        }
        return flag;
    }

    @Transactional
    public int save(User user) throws NoSuchAlgorithmException {
        Random random = new Random();
        user.setSalt(random.nextInt(Constants.SALT));
        user.setPassword(CryptoUtil.digest(user.getPassword(), user.getSalt()));
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User get(String username) {
        return userRepository.query(username);
    }

    @Transactional(readOnly = true)
    public int getSalt(String username) {
        return userRepository.querySalt(username);
    }

}
