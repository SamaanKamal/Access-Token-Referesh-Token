package com.example.Access_token_and_Refresh_token;

import com.example.Access_token_and_Refresh_token.Entity.Role;
import com.example.Access_token_and_Refresh_token.Service.Role.RoleService;
import com.example.Access_token_and_Refresh_token.Service.User.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

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



        };
    }
}
