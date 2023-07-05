package com.s3.practice.application.service;

import com.s3.practice.adapter.out.LoadGymPersistenceAdapter;
import com.s3.practice.adapter.out.UpdateGymPersistenceAdapter;
import com.s3.practice.application.port.in.GymUseCase;
import com.s3.practice.application.port.out.LoadGymPort;
import com.s3.practice.application.port.out.UpdateGymPort;
import com.s3.practice.domain.Gym;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GymService implements GymUseCase {

    private final UpdateGymPort ugp;
    private final LoadGymPort lgp;

    @Override
    @Transactional
    public void register(Gym gym) {
        ugp.save(gym);
    }

    @Override
    public Gym findById(Long id) {
        Optional<Gym> gym = lgp.findById(id);

        if(gym == null) {
            throw new IllegalStateException("존재하지 않는 헬스장입니다.");
        }

        return gym.get();
    }

    @Override
    public List<Gym> findAll() {
        return lgp.findAll();
    }
}
