package com.satyendra.lld.auctionsystem;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<Integer, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void createUser(int id, String name, UserType userType) {
        users.putIfAbsent(id, new User(id, name, userType));
    }

    public void addBuyer(int id, String name) {
        users.putIfAbsent(id, new User(id, name, UserType.BUYER));
    }

    public void addSeller(int id, String name) {
        users.putIfAbsent(id, new User(id, name, UserType.SELLER));
    }

    public User getUser(int id) {
        return users.getOrDefault(id, null);
    }
}
