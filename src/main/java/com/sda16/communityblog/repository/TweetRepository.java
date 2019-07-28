package com.sda16.communityblog.repository;

import com.sda16.communityblog.domain.TweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<TweetEntity, Long> {

    boolean existsByTweetId(Long tweetId);
}
