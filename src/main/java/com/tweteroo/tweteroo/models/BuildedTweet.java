package com.tweteroo.tweteroo.models;

public class BuildedTweet {

  public BuildedTweet(Tweet tweet, String avatar) {
    this.text = tweet.text;
    this.username = tweet.username;
    this.avatar = avatar;
  }

  public String text;
  public String username;
  public String avatar;
}
