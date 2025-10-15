package org.twitter.service;

import org.twitter.model.User;
import org.twitter.service.interfaces.EditService;

public class EditProfile implements EditService {

    @Override
    public void changeUsername(User user, String newUsername) {
        if (newUsername == null || newUsername.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        user.setUserName(newUsername.trim());
    }

    @Override
    public void changePassword(User user, String newPassword) {
        if (!Utility.isValidPassword(newPassword)) {
            throw new IllegalArgumentException("Invalid password format!");
        }
        user.setPassword(Utility.hashPassword(newPassword));
    }

    @Override
    public void changeAge(User user, int newAge) {
        if (newAge <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }
        user.setAge(newAge);
    }

    @Override
    public void changeBio(User user, String newBio) {
        if (newBio == null) {
            throw new IllegalArgumentException("Bio cannot be null.");
        }
        user.setBio(newBio.trim());
    }
}
