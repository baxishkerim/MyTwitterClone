package com.example.sweatermvc.controller;


import com.example.sweatermvc.domain.Role;
import com.example.sweatermvc.domain.User;
import com.example.sweatermvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());

        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {


        model.addAttribute("user ", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user)
    {
        userService.saveUser(user,username,form);

        return "redirect:/user";
    }

        @GetMapping("profile")
        public String getProfile(Model model, @AuthenticationPrincipal User user){
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email",user.getEmail());

            return "profile";
        }


        @PostMapping("profile")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @RequestParam String password,
                                @RequestParam String email)
        {
        userService.updateProfile(user,password,email);

            return "redirect:/user/profile";
        }


}
