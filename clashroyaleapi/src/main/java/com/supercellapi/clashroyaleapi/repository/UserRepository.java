package com.supercellapi.clashroyaleapi.repository;

import com.supercellapi.clashroyaleapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author LucasDonizeti
 */
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
