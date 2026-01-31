package ru.top.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.top.security.entities.User;
import ru.top.security.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public String user(Authentication authentication) {
        return "Hello User " + authentication.getName() + "!";
    }

    @GetMapping("/dashboard")
    public String userDashboard() {
        return "Welcome to User Dashboard!";
    }

    @GetMapping("/profile")
    public ResponseEntity<User> userProfile(Authentication authentication) {
        return ResponseEntity.ok(userService.findByUsername(authentication.getName()));
    }
}
