package com.s3.practice.service;

import com.s3.practice.domain.Gym;
import com.s3.practice.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GymService {

    private final GymRepository gymRepository;

    @Transactional
    public Long register(Gym gym) {
        return gymRepository.save(gym);
    }

    public Gym findOne(Long id) {
        return gymRepository.findOne(id);
    }

    public List<Gym> findAll() {
        return gymRepository.findAll();
    }
}
