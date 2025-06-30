package com.example.Access_token_and_Refresh_token.Repository;

import com.example.Access_token_and_Refresh_token.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
