package com.web.controller;

import com.web.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }


    @GetMapping("/new")
    public String createUserForm(@ModelAttribute("newUser") User user) {
        System.out.println("new user");
        return "user-create";
    }


    @PostMapping("/new")
    public String createUser(@Valid @RequestBody @ModelAttribute("newUser") User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-create";
        }

        userService.save(user);
        return "redirect:/users";
    }


    @GetMapping("/edit-form")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        Optional<User> userById = userService.findById(id);

        if (userById.isPresent()) {
            model.addAttribute("user", userById.get());
            return "edit-user";
        } else {
            return "redirect:/users";
        }
    }


    @PostMapping("/edit")
    public String editUser(@Valid @RequestBody @ModelAttribute("user") User user,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "edit-user";
        }

        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}