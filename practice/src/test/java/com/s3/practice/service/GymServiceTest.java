package com.s3.practice.service;

import com.s3.practice.domain.Gym;
import com.s3.practice.repository.GymRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class GymServiceTest {

    @Autowired GymService gymService;
    @Autowired GymRepository gymRepository;

    @Test
    public void 암장_등록() throws Exception {
        // given
        Gym gym = new Gym();

        // when
        Long savedId = gymService.register(gym);

        // then
        assertEquals(savedId, gymRepository.findOne(savedId).getId());
    }
}