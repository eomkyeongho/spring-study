package com.s3.practice.adapter.out;

import com.s3.practice.adapter.out.jpa.UserJpaRepository;
import com.s3.practice.application.port.out.LoadUserPort;
import com.s3.practice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoadUserPersistenceAdapter implements LoadUserPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll();
    }

    @Override
    public List<User> findByUsername(String Username) {
        return userJpaRepository.findByUsername(Username);
    }

    @Override
    public List<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }
}
