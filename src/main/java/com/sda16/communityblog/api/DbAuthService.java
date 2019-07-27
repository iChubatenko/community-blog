package com.sda16.communityblog.api;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Profile("develop")
public class DbAuthService implements AuthService {

    @Override
    public void auth() {
        System.out.println("DB AUTH SERVICE");
    }

    @PostConstruct
    public void init() {
        auth();
    }
}
