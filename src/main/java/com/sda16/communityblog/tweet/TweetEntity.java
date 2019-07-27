package com.sda16.communityblog.tweet;

import com.sda16.communityblog.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TweetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId;
    @Column
    private String message;
    @DateTimeFormat
    private LocalDate date;
    @Column(length = 150, unique = true)
    private String email;

//    @OneToMany
//    @JoinTable(name = "user_entity")
//    private Set<UserEntity> userEntities;
//
//
//    public TweetEntity(Long valueOf, String anyPost, LocalDate now, String anyEmail) {
//
//    }
}
