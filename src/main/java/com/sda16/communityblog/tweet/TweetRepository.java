package com.sda16.communityblog.tweet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<TweetEntity, Long> {

    boolean existsByTweetId(Long tweetId);
}
