package com.example.Access_token_and_Refresh_token.Repository;

import com.example.Access_token_and_Refresh_token.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
