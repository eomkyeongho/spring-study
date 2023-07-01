package com.s3.practice.application.port.out;

import com.s3.practice.domain.User;

public interface UpdateUserPort {
    void save(User user);
}
