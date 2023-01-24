package com.tweteroo.tweteroo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.DTOs.TweetDTO;
import com.tweteroo.tweteroo.middlewares.ErrorHandler;
import com.tweteroo.tweteroo.models.BuildedTweet;
import com.tweteroo.tweteroo.services.TweetService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/tweets")
public class TweetController extends ErrorHandler{

  @Autowired
  private TweetService service;

  @PostMapping
  public String save(@RequestBody @Valid TweetDTO tweet) throws ValidationException {
    service.saveTweet(tweet);
    return "OK";
  }

  @GetMapping
  public List<BuildedTweet> getTweets(@RequestParam("page") int page) {
    return service.getTweets(page);
  }

  @GetMapping("/{username}")
  public List<BuildedTweet> getuserTweets(@PathVariable String username, @RequestParam("page") int page) throws ValidationException {
    return service.getTweetsByUsername(username, page);
  }
}
