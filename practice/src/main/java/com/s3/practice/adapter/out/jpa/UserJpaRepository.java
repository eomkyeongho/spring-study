package com.s3.practice.adapter.out.jpa;

import com.s3.practice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(String email);
    List<User> findByUsername(String username);
}
