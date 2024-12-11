package com.satyendra.lld.meetingRoomAllocator;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }
}
