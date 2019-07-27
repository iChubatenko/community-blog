package com.sda16.communityblog.tweet;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

    private TweetRepository tweetRepository;

    TweetEntity tweet = new TweetEntity();


}
