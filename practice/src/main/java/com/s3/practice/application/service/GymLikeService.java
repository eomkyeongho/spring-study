package com.s3.practice.application.service;

import com.s3.practice.adapter.out.LoadGymLikePersistenceAdapter;
import com.s3.practice.adapter.out.UpdateGymLikePersistenceAdapter;
import com.s3.practice.application.port.in.GymLikeUseCase;
import com.s3.practice.domain.GymLike;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GymLikeService implements GymLikeUseCase {

    private final LoadGymLikePersistenceAdapter lgp;
    private final UpdateGymLikePersistenceAdapter ugp;

    @Override
    @Transactional
    public void like(Long userId, Long gymId) {
        GymLike gymLike = new GymLike();
        gymLike.setUserId(userId);
        gymLike.setGymId(gymId);

        ugp.save(gymLike);
    }

    @Override
    @Transactional
    public void unlike(Long userId, Long gymId) {
        List<GymLike> gymLikes = lgp.findGymLikesByUserIdAndGymId(userId, gymId);

        if(gymLikes.isEmpty()) {
            throw new IllegalStateException("좋아요를 누르지 않은 헬스장입니다.");
        }

        ugp.delete(gymLikes.get(0));
    }

    @Override
    public List<GymLike> findGymLikesByUserId(Long userId) {
        return lgp.findGymLikesByUserId(userId);
    }

    @Override
    public List<GymLike> findGymLikesByGymId(Long gymId) {
        return lgp.findGymLikesByGymId(gymId);
    }
}
