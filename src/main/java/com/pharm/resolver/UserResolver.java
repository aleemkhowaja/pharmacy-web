package com.pharm.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pharm.model.User;
import com.pharm.service.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResolver implements GraphQLResolver<User>{

    @Autowired
    private UserService userService;

        public User getUser(final User user )
        {
        return userService.findById(user.getId());
    }
}
