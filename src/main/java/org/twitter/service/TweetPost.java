package org.twitter.service;

import org.twitter.model.Tweet;
import org.twitter.repository.TweetRepository;
import org.twitter.service.interfaces.TweetService;

public class TweetPost implements TweetService {

    @Override
    public boolean postTweet(String userId, String tweetContent) {
        final Tweet tweet = new Tweet(userId, tweetContent);
        return TweetRepository.addTweet(tweet);
    }
}
