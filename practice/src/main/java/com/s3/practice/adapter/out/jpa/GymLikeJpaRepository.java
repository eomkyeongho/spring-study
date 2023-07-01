package com.s3.practice.adapter.out.jpa;

import com.s3.practice.domain.GymLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GymLikeJpaRepository extends JpaRepository<GymLike, Long> {
    List<GymLike> findByUserIdAndGymId(Long userId, Long gymId);

    List<GymLike> findByUserId(Long userId);

    List<GymLike> findByGymId(Long gymId);
}
