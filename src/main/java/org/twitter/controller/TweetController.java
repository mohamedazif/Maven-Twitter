package org.twitter.controller;

import org.twitter.service.ServiceFactory;
import org.twitter.service.interfaces.TweetService;

public final class TweetController {

    private final TweetService tweetService;

    public TweetController() {
        this.tweetService = ServiceFactory.getInstance().getTweetService();
    }

    public boolean postTweet(String userId, String tweetContent) {
        return tweetService.postTweet(userId, tweetContent);
    }
}
