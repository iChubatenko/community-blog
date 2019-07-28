package com.sda16.communityblog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class EditUserForm {

    @NotNull
    private Long id;
    @NotNull(message = "This line cannot be empty.")
    private String firstName;
    @NotBlank(message = "This line cannot be empty.")
    private String lastName;
    @NotNull
    @Email(message = "Incorrect email.")
    private String email;
    @NotEmpty
    private Collection<String> roles;

    public static EditUserForm create(UserEntity user) {
        EditUserForm form = new EditUserForm();
        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setRoles(user.getRoles().stream()
                .map(RoleEntity::getRoleName)
                .collect(Collectors.toSet()));
        return form;
    }
}
