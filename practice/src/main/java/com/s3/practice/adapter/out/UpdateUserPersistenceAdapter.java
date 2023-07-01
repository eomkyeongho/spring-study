package com.s3.practice.adapter.out;

import com.s3.practice.adapter.out.jpa.UserJpaRepository;
import com.s3.practice.application.port.out.UpdateUserPort;
import com.s3.practice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateUserPersistenceAdapter implements UpdateUserPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public void save(User user) {
        userJpaRepository.save(user);
    }
}
