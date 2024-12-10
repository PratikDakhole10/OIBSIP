package com.app.service;

import com.app.model.User;
import com.app.repository.UserRepository;

public class AuthService {
	public static User authenticate(String userId, String pin) {
        User user = UserRepository.getInstance().getUser(userId);
        return (user != null && user.getPin().equals(pin)) ? user : null;
    }
}
