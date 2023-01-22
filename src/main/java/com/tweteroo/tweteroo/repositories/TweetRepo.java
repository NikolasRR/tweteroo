package com.tweteroo.tweteroo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.Tweet;

public interface TweetRepo extends JpaRepository<Tweet, Long>{
}
