package com.s3.practice.repository;

import com.s3.practice.domain.Gym;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GymRepository {

    private final GymJpaRepository gymJpaRepository;

    public void save(Gym gym) {
        gymJpaRepository.save(gym);
    }

    public Optional<Gym> findOne(Long id) {
        return gymJpaRepository.findById(id);
    }

    public List<Gym> findAll() {
        return gymJpaRepository.findAll();
    }

    public List<Gym> findByName(String name) {
        return gymJpaRepository.findByName(name);
    }
}
