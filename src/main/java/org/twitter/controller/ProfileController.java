package org.twitter.controller;

import org.twitter.model.User;
import org.twitter.service.ServiceFactory;
import org.twitter.service.interfaces.ProfileService;

import java.util.List;

public final class ProfileController {
    private final ProfileService profileService;

    public ProfileController() {
        this.profileService = ServiceFactory.getInstance().getProfileService();
    }

    public List<Object> getUserProfileTweets(User user) {
        return profileService.getUserProfileTweets(user);
    }
}
