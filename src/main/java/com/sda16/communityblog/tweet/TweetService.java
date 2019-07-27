package com.sda16.communityblog.tweet;

import com.sda16.communityblog.user.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.transaction.TransactionScoped;

@Service
@Getter
@Setter
public class TweetService {

    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void postTwets(TweetEntity tweetEntity) throws Exception {

        if (tweetRepository.count() == 0) {
            throw new Exception("No tweets available to you");
        }


        TweetEntity tweet = new TweetEntity();
        tweet.setTweetId(tweetEntity.getTweetId());
        tweet.setMessage(tweetEntity.getMessage());
        tweet.setDate(tweetEntity.getDate());
        tweet.setEmail(tweetEntity.getEmail());


        tweetRepository.save(tweet);


    }

    @PostConstruct
    void init() {
    }

}
