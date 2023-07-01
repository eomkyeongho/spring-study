package com.s3.practice.adapter.out;

import com.s3.practice.adapter.out.jpa.GymLikeJpaRepository;
import com.s3.practice.application.port.out.UpdateGymLikePort;
import com.s3.practice.domain.GymLike;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateGymLikePersistenceAdapter implements UpdateGymLikePort {
    private final GymLikeJpaRepository gymLikeJpaRepository;

    @Override
    public void save(GymLike gymLike) {
        gymLikeJpaRepository.save(gymLike);
    }

    @Override
    public void delete(GymLike gymLike) {
        gymLikeJpaRepository.delete(gymLike);
    }
}
