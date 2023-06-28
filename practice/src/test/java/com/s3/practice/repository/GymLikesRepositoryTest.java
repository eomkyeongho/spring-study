package com.s3.practice.repository;

import com.s3.practice.domain.GymLikes;
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
class GymLikesRepositoryTest {

    @Autowired GymLikesRepository gymLikesRepository;

    @Test
    public void 좋아요_저장_삭제() throws Exception {
        GymLikes gymLikes = new GymLikes();
        gymLikes.setGymId(1L);
        gymLikes.setUserId(1L);

        Long savedId = gymLikesRepository.save(gymLikes);
        GymLikes findGymLikes = gymLikesRepository.findOne(savedId);

        assertEquals(findGymLikes.getId(), gymLikes.getId());

        gymLikesRepository.delete(findGymLikes);
        GymLikes findGymLikes2 = gymLikesRepository.findOne(savedId);

        assertNull(findGymLikes2);
    }
}