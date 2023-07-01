package com.s3.practice.application.port.in;

import com.s3.practice.domain.GymLike;

import java.util.List;

public interface GymLikeUseCase {

    void like(Long userId, Long gymId);

    void unlike(Long userId, Long gymId);

    List<GymLike> findGymLikesByUserId(Long userId);

    List<GymLike> findGymLikesByGymId(Long gymId);
}
