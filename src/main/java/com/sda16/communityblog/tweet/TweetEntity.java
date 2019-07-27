package com.sda16.communityblog.tweet;

import com.sda16.communityblog.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TweetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId;
    @Column
    private String message;
    private LocalDate date;
    @Column(length = 150, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "TWEET_ID")
    private Collection<TweetCommentEntity> comments;

    public TweetEntity(Long tweetId, String anyMassage, LocalDate date, String anyEmail) {

    }

    @Override
    public String toString() {
        return "TweetEntity{" +
                "tweetId=" + tweetId +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", email='" + email + '\'' +
                '}';
    }
}
