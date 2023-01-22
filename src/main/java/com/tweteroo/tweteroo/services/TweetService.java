package com.tweteroo.tweteroo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    var user = userRepo.findByUsername(tweet.username());
    if (user.isEmpty()) throw new Error();

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


}
