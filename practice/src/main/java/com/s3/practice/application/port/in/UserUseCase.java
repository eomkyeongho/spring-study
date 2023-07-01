package com.s3.practice.application.port.in;

import com.s3.practice.domain.User;

import java.util.List;

public interface UserUseCase {

    void join(User user);


    List<User> findAll();

    User findById(Long id);
}
