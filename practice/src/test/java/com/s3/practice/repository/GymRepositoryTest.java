package com.s3.practice.repository;

import com.s3.practice.domain.Gym;
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
class GymRepositoryTest {

    @Autowired GymRepository gymRepository;

    @Test
    public void 암장_저장() throws Exception {
        Gym gym = new Gym();
        gym.setName("암장A");

        Long savedId = gymRepository.save(gym);
        Gym findGym = gymRepository.findOne(savedId);

        assertEquals(findGym.getId(), gym.getId());
    }
}