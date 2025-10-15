package org.twitter.service;

import org.twitter.model.User;
import org.twitter.repository.UserRepository;
import org.twitter.service.interfaces.RegisterService;

public final class UserRegister implements RegisterService {

    @Override
    public boolean registerUser(User user) {
        return UserRepository.addRegisteredUser(user);
    }
}
