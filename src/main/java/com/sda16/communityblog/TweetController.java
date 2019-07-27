package com.sda16.communityblog;

import com.sda16.communityblog.tweet.TweetEntity;
import com.sda16.communityblog.tweet.TweetService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class TweetController {

    private TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping("/tweets")
    public String showTweets(Model model) {

        TweetEntity tweetEntity = new TweetEntity(Long.valueOf(1L), "Any post", LocalDate.now(), "Any email");
        model.addAttribute("tweet", tweetEntity);

        return "tweets";
    }
}
