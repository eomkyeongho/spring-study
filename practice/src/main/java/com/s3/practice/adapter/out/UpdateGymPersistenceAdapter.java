package com.s3.practice.adapter.out;

import com.s3.practice.adapter.out.jpa.GymJpaRepository;
import com.s3.practice.application.port.out.UpdateGymPort;
import com.s3.practice.domain.Gym;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateGymPersistenceAdapter implements UpdateGymPort {

    private final GymJpaRepository gymJpaRepository;

    @Override
    public void save(Gym gym) {
        gymJpaRepository.save(gym);
    }
}
