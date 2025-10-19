package com.example.Access_token_and_Refresh_token;

import com.example.Access_token_and_Refresh_token.Entity.Role;
import com.example.Access_token_and_Refresh_token.Entity.User;
import com.example.Access_token_and_Refresh_token.Service.Role.RoleService;
import com.example.Access_token_and_Refresh_token.Service.User.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;

@SpringBootApplication
@PropertySource("classpath:env.properties")
public class AccessTokenAndRefreshTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessTokenAndRefreshTokenApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService, RoleService roleService){
        return args -> {
            roleService.saveRole(new Role(null, "USER"));
            roleService.saveRole(new Role(null, "ADMIN"));
            roleService.saveRole(new Role(null, "MANAGER"));
            roleService.saveRole(new Role(null, "SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Arnold Schwarzenegger", "Arnold", "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "USER");
            userService.addRoleToUser("john", "MANAGER");
            userService.addRoleToUser("will", "MANAGER");
            userService.addRoleToUser("jim", "ADMIN");
            userService.addRoleToUser("arnold", "SUPER_ADMIN");
            userService.addRoleToUser("arnold", "ADMIN");
            userService.addRoleToUser("arnold", "USER");
        };
    }
}
