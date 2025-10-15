package org.twitter.controller;

import org.twitter.model.User;
import org.twitter.service.ServiceFactory;
import org.twitter.service.interfaces.FollowSuggestionService;

import java.util.List;

public class FollowSuggestionController {

    private final FollowSuggestionService followSuggestionService;

    public FollowSuggestionController() {
        this.followSuggestionService = ServiceFactory.getInstance().getFollowSuggestionService();
    }

    public List<User> getSuggestedUser(User user) {
        return followSuggestionService.getSuggestedUsers(user);
    }

    public void followUser(User follower, User toFollow) {
        followSuggestionService.followUser(follower, toFollow);
    }
}
