package org.twitter.controller;

import org.twitter.model.Tweet;
import org.twitter.model.User;
import org.twitter.service.ServiceFactory;
import org.twitter.service.interfaces.TimelineService;

import java.util.Collection;

public final class TimelineController {

    private final TimelineService timelineService;

    public TimelineController() {
        this.timelineService = ServiceFactory.getInstance().getTimeLineService();
    }

    public Collection<Tweet> getTimelineTweets(User user) {
        return timelineService.getTimelineTweets(user);
    }

    public boolean likeTweet(User user, Tweet tweet) {
        return timelineService.likeTweet(user, tweet);
    }

    public boolean retweet(User user, Tweet tweet) {
        return timelineService.retweet(user, tweet);
    }
}
