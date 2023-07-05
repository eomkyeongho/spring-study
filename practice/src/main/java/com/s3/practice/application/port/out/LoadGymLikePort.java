package com.s3.practice.application.port.out;

import com.s3.practice.domain.GymLike;

import java.util.List;
import java.util.Optional;

public interface LoadGymLikePort {
    Optional<GymLike> findById(Long id);

    List<GymLike> findByUserIdAndGymId(Long userId, Long gymId);

    List<GymLike> findByUserId(Long userId);

    List<GymLike> findByGymId(Long gymId);
}
