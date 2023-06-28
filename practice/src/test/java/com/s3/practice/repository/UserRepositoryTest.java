package com.s3.practice.repository;

import com.s3.practice.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    public void 유저_저장() throws Exception {
        User user = new User();
        user.setUsername("userA");

        Long savedId = userRepository.save(user);
        User findUser = userRepository.findOne(savedId);

        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());
    }
}