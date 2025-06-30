package com.example.Access_token_and_Refresh_token.Controller;

import com.example.Access_token_and_Refresh_token.Entity.Role;
import com.example.Access_token_and_Refresh_token.Service.Role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        roleService.saveRole(role);
        return ResponseEntity.ok(role);
    }
}
