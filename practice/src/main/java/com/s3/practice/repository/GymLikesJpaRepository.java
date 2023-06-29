package com.s3.practice.repository;

import com.s3.practice.domain.GymLikes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GymLikesJpaRepository extends JpaRepository<GymLikes, Long> {
    List<GymLikes> findByUserIdAndGymId(Long userId, Long gymId);

    List<GymLikes> findByUserId(Long userId);

    List<GymLikes> findByGymId(Long gymId);
}
