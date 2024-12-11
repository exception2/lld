package com.satyendra.lld.issuemanagement.service;

import com.satyendra.lld.issuemanagement.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    Map<String, User> userMap;

    public UserServiceImpl() {
        userMap = new HashMap<>();
    }

    @Override
    public User createUser(String name) {
        User user = new User(name);
        userMap.put(user.getId(), user);
        return user;
    }
}
