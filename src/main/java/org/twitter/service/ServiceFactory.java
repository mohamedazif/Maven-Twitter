package org.twitter.service;

import org.twitter.service.interfaces.*;

public final class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private ServiceFactory() { }

    public static ServiceFactory getInstance() { return INSTANCE; }

    public RegisterService getRegisterService() {
        return new UserRegister();
    }

    public LoginService getLoginService() {
        return new UserLogin();
    }

    public TimelineService getTimeLineService() {
        return new UserTimeline();
    }

    public ProfileService getProfileService() {
        return new UserProfile();
    }

    public TweetService getTweetService() {
        return new TweetPost();
    }

    public FollowSuggestionService getFollowSuggestionService() {
        return new FollowSuggestions();
    }

    public EditService getEditService() {
        return new EditProfile();
    }
}
