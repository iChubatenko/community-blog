package com.sda16.communityblog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString(exclude = {"password"})
public class SignUpForm {

    @NotNull(message = "This line cannot be empty.")
    private String firstName;
    @NotBlank(message = "This line cannot be empty.")
    private String lastName;
    @Pattern(regexp = "[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-z]{2,3}",
            message = "Incorrect email.")
    private String email;
    @Size(min = 6, max = 50, message = "Password must be from 6 to 50 characters")
    private String password;
}
