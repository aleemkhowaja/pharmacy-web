package com.pharm.controller.user;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.User;
import com.pharm.service.impl.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private UserServiceImpl userService;

    public List<User> getAllUsers(){
        return userService.findAll();
    }

    public User getUserById(final Long id){
        return userService.findById(id);
    }

    public User createUser(final User user){
        return userService.create(user);
    }

    public User updateUser(final User user){
        return userService.update(user);
    }

    public User deleteCountry(final Long id){
        User User = new User();
        User.setId(id);
        return userService.delete(User);
    }
}
