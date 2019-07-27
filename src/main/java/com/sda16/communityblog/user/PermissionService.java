package com.sda16.communityblog.user;

import com.sda16.communityblog.config.UsersRole;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;

import static com.sda16.communityblog.config.UsersRole.ADMIN;
import static com.sda16.communityblog.config.UsersRole.USER;

@Service
@SessionScope
public class PermissionService {

    public boolean isAdmin() {
        return isUserInRole(ADMIN);
    }

    public boolean isUser() {
        return isUserInRole(USER);
    }

    public boolean isUserInRole(UsersRole usersRole) {
        Authentication userAuthentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (userAuthentication == null) {
            return false;
        }
        return userAuthentication
                .getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equalsIgnoreCase(usersRole.getAuthorityName()));
    }

    public boolean isUserInAnyRole(String ... role) {
        return Arrays.stream(role)
                .map(roleAsString -> UsersRole.valueOf(roleAsString.toUpperCase()))
                .anyMatch(this::isUserInRole);
    }

    public String getCurrentUserName() {
        Authentication userAuthentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (userAuthentication == null) {
            return null;
        }
        return userAuthentication.getName();
    }
}
