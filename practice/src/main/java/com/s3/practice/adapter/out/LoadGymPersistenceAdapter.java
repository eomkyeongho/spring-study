package com.s3.practice.adapter.out;

import com.s3.practice.adapter.out.jpa.GymJpaRepository;
import com.s3.practice.application.port.out.LoadGymPort;
import com.s3.practice.domain.Gym;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoadGymPersistenceAdapter implements LoadGymPort {

    private final GymJpaRepository gymJpaRepository;

    @Override
    public Optional<Gym> findById(Long id) {
        return gymJpaRepository.findById(id);
    }

    @Override
    public List<Gym> findAll() {
        return gymJpaRepository.findAll();
    }

    @Override
    public List<Gym> findByName(String name) {
        return gymJpaRepository.findByName(name);
    }
}
