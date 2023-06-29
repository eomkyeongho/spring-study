package com.s3.practice.repository;

import com.s3.practice.domain.GymLikes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GymLikesRepository{

    private final GymLikesJpaRepository gymLikesJpaRepository;

    public void save(GymLikes gymLikes) {
        gymLikesJpaRepository.save(gymLikes);
    }

    public void delete(GymLikes gymLikes) {
        gymLikesJpaRepository.delete(gymLikes);
    }

    public Optional<GymLikes> findOne(Long id) {
        return gymLikesJpaRepository.findById(id);
    }

    public List<GymLikes> findGymLikesByUserIdAndGymId(Long userId, Long gymId) {
        return gymLikesJpaRepository.findByUserIdAndGymId(userId, gymId);
    }

    public List<GymLikes> findGymLikesByUserId(Long userId) {
        return gymLikesJpaRepository.findByUserId(userId);
    }

    public List<GymLikes> findGymLikesByGymId(Long gymId) {
        return gymLikesJpaRepository.findByGymId(gymId);
    }
}
