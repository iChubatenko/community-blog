package com.sda16.communityblog.user;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String firstName;
    @Column(length = 100)
    private String lastName;
    @Column(length = 150, unique = true)
    private String email;

    private String password;


}
