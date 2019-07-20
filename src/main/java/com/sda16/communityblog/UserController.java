package com.sda16.communityblog;

import com.sda16.communityblog.user.EmailAlreadyExistsException;
import com.sda16.communityblog.user.SignUpForm;
import com.sda16.communityblog.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String showRegisterForm(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUpForm";
    }

    @PostMapping("/signup")
    public String handleRegisterForm(
            @ModelAttribute @Valid SignUpForm signUpForm,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        if (bindingResult.hasErrors()) {
            return "signUpForm";
        }

        try {
            userService.signUpUser(signUpForm);
        } catch (EmailAlreadyExistsException e) {
            bindingResult.rejectValue("email", "email-duplicate", "This e-mail has previously been registered");
            return "signUpForm";
        }
        redirectAttributes.addFlashAttribute("msg", "Thank you for registering!");
        return "redirect:/";
    }
}
