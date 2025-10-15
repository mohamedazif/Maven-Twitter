package org.twitter.service;

import org.twitter.model.User;
import org.twitter.repository.UserRepository;
import org.twitter.service.interfaces.FollowSuggestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FollowSuggestions implements FollowSuggestionService {

    @Override
    public List<User> getSuggestedUsers(User user) {
        List<User> suggestions = new ArrayList<>();
        Map<String, User> usersList = UserRepository.getUsersList();

        for (User suggUser : usersList.values()) {
            if (!suggUser.getUserId().equals(user.getUserId()) &&
                    !user.getFollowing().contains(suggUser.getUserId())) {
                suggestions.add(suggUser);
            }
        }

        return suggestions;
    }

    @Override
    public void followUser(User follower, User toFollow) {
        if (!follower.getFollowing().contains(toFollow.getUserId())) {
            follower.getFollowing().add(toFollow.getUserId());
            toFollow.getFollowers().add(follower.getUserId());
        }
    }
}
