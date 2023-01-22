package com.tweteroo.tweteroo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.DTOs.TweetDTO;
import com.tweteroo.tweteroo.models.BuildedTweet;
import com.tweteroo.tweteroo.models.Tweet;
import com.tweteroo.tweteroo.repositories.TweetRepo;
import com.tweteroo.tweteroo.repositories.UserRepo;

@Service
public class TweetService {
  
  @Autowired
  private TweetRepo tweetRepo;

  @Autowired
  private UserRepo userRepo;

  public void saveTweet(TweetDTO tweet) {
    this.userExists(tweet.username());
    tweetRepo.save(new Tweet(tweet));
  }

  public List<BuildedTweet> getTweets(int page) {
    var tweets = tweetRepo.findAll(PageRequest.of(page, 5).withSort(Direction.DESC, "id"));
    List<BuildedTweet> buildedTweets = new ArrayList<>();
    
    for (Tweet tweet : tweets) {
      var username = userRepo.findByUsername(tweet.username).get(0);
      buildedTweets.add(new BuildedTweet(tweet, username.avatar));
    }

    return buildedTweets;
  }

  public List<BuildedTweet> getTweetsByUsername(String username, int page) {
    this.userExists(username);

    var tweets = tweetRepo.findByUsername(username, PageRequest.of(page, 5).withSort(Direction.DESC, "id"));
    var user = userRepo.findByUsername(username).get(0);

    List<BuildedTweet> buildedTweets = new ArrayList<>();
    tweets.getContent().forEach(tweet -> buildedTweets.add(new BuildedTweet(tweet, user.avatar)));

    return  buildedTweets;
  }

  private void userExists(String username) {
    var user = userRepo.findByUsername(username);
    if (user.isEmpty()) throw new Error(); 
  }
}
