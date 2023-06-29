package com.s3.practice.repository;

import com.s3.practice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserJpaRepository userJpaRepository;

    public void save(User user) {
        userJpaRepository.save(user);
    }

    public Optional<User> findOne(Long id) {
        return userJpaRepository.findById(id);
    }

    public List<User> findAll() {
        return userJpaRepository.findAll();
    }

    public List<User> findByUsername(String Username) {
        return userJpaRepository.findByUsername(Username);
    }

    public List<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }
}
