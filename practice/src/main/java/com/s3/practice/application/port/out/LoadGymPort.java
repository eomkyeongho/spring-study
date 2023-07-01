package com.s3.practice.application.port.out;

import com.s3.practice.domain.Gym;

import java.util.List;
import java.util.Optional;

public interface LoadGymPort {
    Optional<Gym> findById(Long id);

    List<Gym> findAll();

    List<Gym> findByName(String name);
}
