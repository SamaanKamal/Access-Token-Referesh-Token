package com.example.Access_token_and_Refresh_token.Service.User;

import com.example.Access_token_and_Refresh_token.Entity.Role;
import com.example.Access_token_and_Refresh_token.Entity.User;
import com.example.Access_token_and_Refresh_token.Repository.RoleRepository;
import com.example.Access_token_and_Refresh_token.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        return userRepository.save(user);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("adding new role {} to the user {}", roleName, username);
        Role role = roleRepository.findByName(roleName);
        User user = userRepository.findByUsername(username);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("getting user {}  info", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("getting  users");
        return userRepository.findAll();
    }
}
