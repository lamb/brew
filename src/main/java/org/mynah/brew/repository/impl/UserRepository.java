package org.mynah.brew.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.mynah.brew.jdbc.Template;
import org.mynah.brew.model.User;
import org.mynah.brew.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private Template template;

    @Override
    public String queryPassword(String username) {
        return template.queryForObject("select password from user where username=?", String.class, username);
    }

    @Override
    public User query(String username) {
        return template.queryForObject("select * from user where username=?", new BeanPropertyRowMapper<User>(User.class), username);
    }

    @Override
    public int save(User user) {
        return template.insert(user);
    }

    @Override
    public int querySalt(String username) {
        return template.queryForInt("select salt from user where username=?", username);
    }

}
