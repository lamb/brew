package org.mynah.brew.repository;

import org.mynah.brew.model.User;

public interface IUserRepository {

    String queryPassword(String username);

    User query(String username);

    int querySalt(String username);

    int save(User user);

}
