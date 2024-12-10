package com.app.repository;

import java.util.HashMap;
import java.util.Map;

import com.app.model.User;

public class UserRepository {
	private static UserRepository instance;
    private final Map<String, User> users;

    private UserRepository() {
        users = new HashMap<>();
        // Initial sample users
        users.put("user1", new User("user1", "1234", 5000));
        users.put("user2", new User("user2", "5678", 3000));
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void updateUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void addUser(User user) {
        if (users.containsKey(user.getUserId())) {
            System.out.println("User ID already exists!");
        } else {
            users.put(user.getUserId(), user);
        }
    }
}
