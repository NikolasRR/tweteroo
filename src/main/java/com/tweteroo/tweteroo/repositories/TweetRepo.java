package com.tweteroo.tweteroo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.Tweet;

public interface TweetRepo extends JpaRepository<Tweet, Long>{
  Page<Tweet> findByUsername(String username, PageRequest page);
}
