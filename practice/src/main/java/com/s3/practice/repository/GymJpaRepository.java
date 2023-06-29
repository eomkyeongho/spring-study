package com.s3.practice.repository;

import com.s3.practice.domain.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GymJpaRepository extends JpaRepository<Gym, Long> {

    List<Gym> findByName(String name);
}
