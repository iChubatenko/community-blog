package com.sda16.communityblog.config;

public enum UsersRole {
    ADMIN("ADMIN", "ROLE_ADMIN"),
    USER("USER", "ROLE_USER");

    private String roleName;
    private String authorityName;

    UsersRole(String roleName, String authorityName) {
        this.roleName = roleName;
        this.authorityName = authorityName;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getAuthorityName() {
        return authorityName;
    }
}
