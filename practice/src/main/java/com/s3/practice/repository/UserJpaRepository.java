package com.s3.practice.repository;

import com.s3.practice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(String email);
    List<User> findByUsername(String username);
}
