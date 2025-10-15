package org.twitter.service;

import org.twitter.model.Retweet;
import org.twitter.model.Tweet;
import org.twitter.model.User;
import org.twitter.repository.TweetRepository;
import org.twitter.service.interfaces.TimelineService;

import java.util.Collection;

public final class UserTimeline implements TimelineService {

    @Override
    public Collection<Tweet> getTimelineTweets(User user) {
        return TweetRepository.getTimelineTweets(user);
    }

    @Override
    public boolean likeTweet(User user, Tweet tweet) {

        if (tweet.getLikedBy().contains(user.getUserId())) {
            System.err.println("Tweet already liked!");
            return false;
        }

        tweet.addLikedBy(user.getUserId());
        return true;
    }

    @Override
    public boolean retweet(User user, Tweet tweet) {

        if (tweet.isRetweetedBy(user.getUserId())) {
            System.err.println("Tweet retweeted already!");
            return false;
        }

        tweet.addRetweeter(user.getUserId());
        user.getRetweets().add(new Retweet(tweet, user.getUserId()));
        return true;
    }
}
