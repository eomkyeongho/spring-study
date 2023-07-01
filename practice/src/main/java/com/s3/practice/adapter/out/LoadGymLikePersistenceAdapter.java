package com.s3.practice.adapter.out;

import com.s3.practice.adapter.out.jpa.GymLikeJpaRepository;
import com.s3.practice.application.port.out.LoadGymLikePort;
import com.s3.practice.domain.GymLike;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoadGymLikePersistenceAdapter implements LoadGymLikePort {

    private final GymLikeJpaRepository gymLikeJpaRepository;

    @Override
    public Optional<GymLike> findById(Long id) {
        return gymLikeJpaRepository.findById(id);
    }

    @Override
    public List<GymLike> findGymLikesByUserIdAndGymId(Long userId, Long gymId) {
        return gymLikeJpaRepository.findByUserIdAndGymId(userId, gymId);
    }

    @Override
    public List<GymLike> findGymLikesByUserId(Long userId) {
        return gymLikeJpaRepository.findByUserId(userId);
    }

    @Override
    public List<GymLike> findGymLikesByGymId(Long gymId) {
        return gymLikeJpaRepository.findByGymId(gymId);
    }
}
