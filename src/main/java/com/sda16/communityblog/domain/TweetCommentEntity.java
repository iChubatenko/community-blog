package com.sda16.communityblog.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TweetCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column
    private String commentText;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

}
