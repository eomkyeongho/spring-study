package com.s3.practice.application.service;

import com.s3.practice.adapter.out.LoadUserPersistenceAdapter;
import com.s3.practice.adapter.out.UpdateUserPersistenceAdapter;
import com.s3.practice.application.port.in.UserUseCase;
import com.s3.practice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UpdateUserPersistenceAdapter uup;
    private final LoadUserPersistenceAdapter lup;

    @Override
    @Transactional
    public void join(User user) {
        validateDuplicateUser(user);
        uup.save(user);
    }


    private void validateDuplicateUser(User user) {
        List<User> findUsers = lup.findByUsername(user.getUsername());

        if(!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Override
    public List<User> findAll() {
        return lup.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = lup.findById(id);

        if(user == null) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }

        return user.get();
    }
}
