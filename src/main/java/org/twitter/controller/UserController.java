package org.twitter.controller;

import org.twitter.model.User;
import org.twitter.service.ServiceFactory;
import org.twitter.service.Utility;
import org.twitter.service.interfaces.LoginService;
import org.twitter.service.interfaces.RegisterService;

public final class UserController {

    private final RegisterService registerService;
    private final LoginService loginService;

    public UserController() {
        ServiceFactory factory = ServiceFactory.getInstance();
        this.registerService = factory.getRegisterService();
        this.loginService = factory.getLoginService();
    }

    public boolean registerUser(String userName, String email, String userID,
                             String password, int age, String bio) {
        User user = new User(userName, userID, email,
                Utility.hashPassword(password), age, bio);
        return registerService.registerUser(user);
    }

    public User loginUser(String userId, String password) {
        return loginService.loginUser(userId, password);
    }
}
