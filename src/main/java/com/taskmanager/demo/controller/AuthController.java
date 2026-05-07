package com.taskmanager.demo.controller;

import com.taskmanager.demo.entity.User;
import com.taskmanager.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/{register}")
    public User register(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password){
        return userService.login(email, password);

    }
}
