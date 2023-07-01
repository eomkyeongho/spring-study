package com.s3.practice.application.port.in;

import com.s3.practice.domain.Gym;

import java.util.List;

public interface GymUseCase {

    void register(Gym gym);

    Gym findById(Long id);

    List<Gym> findAll();
}
