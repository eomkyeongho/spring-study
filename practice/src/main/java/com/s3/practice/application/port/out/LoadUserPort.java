package com.s3.practice.application.port.out;

import com.s3.practice.domain.User;

import java.util.List;
import java.util.Optional;

public interface LoadUserPort {
    Optional<User> findById(Long id);

    List<User> findAll();

    List<User> findByUsername(String Username);

    List<User> findByEmail(String email);
}
