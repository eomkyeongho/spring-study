package com.s3.practice.repository;

import com.s3.practice.domain.Gym;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GymRepository {

    private final EntityManager em;

    public Long save(Gym gym) {
        em.persist(gym);
        return gym.getId();
    }

    public Gym findOne(Long id) {
        return em.find(Gym.class, id);
    }

    public List<Gym> findAll() {
        return em.createQuery("select g from Gym g", Gym.class)
                .getResultList();
    }

    public List<Gym> findByName(String name) {
        return em.createQuery("select g from Gym g where g.name = :name", Gym.class)
                .setParameter("name", name)
                .getResultList();
    }
}
