package com.example.Access_token_and_Refresh_token.Controller;

import com.example.Access_token_and_Refresh_token.Entity.User;
import com.example.Access_token_and_Refresh_token.Service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username){
        if(username == null){
            return ResponseEntity.badRequest().body("Username can not be null");
        }
        User user = userService.getUser(username);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUser(){
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/create-user").toUriString());
        User savedUser = userService.saveUser(user);
        return ResponseEntity.created(uri).body(savedUser);
    }

    @PutMapping("/add-role-to-user/{username}/{role-name}")
    public void addRoleToUser(@PathVariable("username") String username, @PathVariable("role-name") String roleName){
        userService.addRoleToUser(username, roleName);
    }
}
