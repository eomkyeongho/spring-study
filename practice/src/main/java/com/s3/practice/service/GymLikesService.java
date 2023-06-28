package com.s3.practice.service;

import com.s3.practice.domain.GymLikes;
import com.s3.practice.repository.GymLikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GymLikesService {

    private final GymLikesRepository gymLikesRepository;

    @Transactional
    public Long like(Long userId, Long gymId) {
        GymLikes gymLikes = new GymLikes();
        gymLikes.setUserId(userId);
        gymLikes.setGymId(gymId);

        return gymLikesRepository.save(gymLikes);
    }

    @Transactional
    public Long unlike(Long userId, Long gymId) {
        GymLikes gymLikes = gymLikesRepository.findGymLikesByUserIdAndGymId(userId, gymId);

        return gymLikesRepository.delete(gymLikes);
    }

    public List<GymLikes> findGymLikesByUserId(Long userId) {
        return gymLikesRepository.findGymLikesByUserId(userId);
    }

    public List<GymLikes> findGymLikesByGymId(Long gymId) {
        return gymLikesRepository.findGymLikesByGymId(gymId);
    }
}
