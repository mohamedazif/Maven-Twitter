package org.twitter.controller;

import org.twitter.model.User;
import org.twitter.service.ServiceFactory;
import org.twitter.service.interfaces.EditService;

public class ProfileEditController {

    private final EditService editService;

    public ProfileEditController() {
        this.editService = ServiceFactory.getInstance().getEditService();
    }

    public void changeUsername(User user, String newUsername) {
        editService.changeUsername(user, newUsername);
    }

    public void changePassword(User user, String newPassword) {
        editService.changePassword(user, newPassword);
    }

    public void changeAge(User user, int newAge) {
        editService.changeAge(user, newAge);
    }

    public void changeBio(User user, String newBio) {
        editService.changeBio(user, newBio);
    }
}
