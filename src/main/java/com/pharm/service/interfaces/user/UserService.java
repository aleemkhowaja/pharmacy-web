package com.pharm.service.interfaces.user;


import com.pharm.model.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();


    User findById(final Long id);

    User create(final User user);

    User update(final User user);

    User delete(final User user);

    User findByUsername(final String username);
}
