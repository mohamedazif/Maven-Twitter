package org.twitter.service;

import org.twitter.model.User;
import org.twitter.repository.UserRepository;
import org.twitter.service.interfaces.LoginService;

public final class UserLogin implements LoginService {

    @Override
    public User loginUser(final String userId, final String password) {
        User logInUser = UserRepository.getSpecificUser(userId);

        if (logInUser != null && logInUser.getUserId().equals(userId)
                && logInUser.getPassword().equals(Utility.hashPassword(password))) {
            return logInUser;
        } else {
            System.err.println("Invalid UserId or Password!");
            return null;
        }
    }
}
