package com.example.Access_token_and_Refresh_token.Service.Role;

import com.example.Access_token_and_Refresh_token.Entity.Role;
import com.example.Access_token_and_Refresh_token.Repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImp implements  RoleService{
    private final RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new Role {} to the database", role.getName());
        return roleRepository.save(role);
    }
}
