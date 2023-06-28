package com.s3.practice.service;

import com.s3.practice.domain.GymLikes;
import com.s3.practice.repository.GymLikesRepository;
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
class GymLikesServiceTest {

    @Autowired GymLikesService gymLikesService;
    @Autowired GymLikesRepository gymLikesRepository;

    @Test
    public void 좋아요_좋아요_취소() throws Exception {
        Long gymId = 1L;
        Long userId = 2L;

        Long saveId = gymLikesService.like(userId, gymId);
        GymLikes findGymLikes = gymLikesRepository.findOne(saveId);

        assertEquals(findGymLikes.getGymId(), gymId);
        assertEquals(findGymLikes.getUserId(), userId);

        gymLikesService.unlike(userId, gymId);
        GymLikes findGymLikes2 = gymLikesRepository.findOne(saveId);

        assertNull(findGymLikes2);
    }
}