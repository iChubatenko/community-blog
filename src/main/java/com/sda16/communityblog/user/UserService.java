package com.sda16.communityblog.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class UserService {

    public static final String ROLE_USER = "ROLE_USER";
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void signUpUser(SignUpForm signUpForm) throws EmailAlreadyExistsException {

        if (userRepository.existsByEmail(signUpForm.getEmail())) {
            throw new EmailAlreadyExistsException("Duplicate email");
        }

        RoleEntity defaultRole = roleRepository.findByRoleName(ROLE_USER)
                .orElseGet(() -> roleRepository.save(new RoleEntity(ROLE_USER)));


        UserEntity user = new UserEntity();
        user.setFirstName(signUpForm.getFirstName());
        user.setLastName(signUpForm.getLastName());
        user.setEmail(signUpForm.getEmail());
        user.setPassword(passwordEncoder.encode(signUpForm.getPassword()));

        user.addRole(defaultRole);

        userRepository.save(user);


    }

    public UserEntity updateUser(EditUserForm editUserForm) {
        return null;
    }

    @PostConstruct
    void init() {
    }
}
