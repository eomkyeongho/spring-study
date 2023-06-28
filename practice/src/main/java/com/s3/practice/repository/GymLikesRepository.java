package com.s3.practice.repository;

import com.s3.practice.domain.GymLikes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GymLikesRepository {

    private final EntityManager em;

    public Long save(GymLikes gymLikes) {
        em.persist(gymLikes);
        return gymLikes.getId();
    }

    public Long delete(GymLikes gymLikes) {
        em.remove(gymLikes);
        return gymLikes.getId();
    }

    public GymLikes findOne(Long id) {
        return em.find(GymLikes.class, id);
    }

    public GymLikes findGymLikesByUserIdAndGymId(Long userId, Long gymId) {
        return em.createQuery("select l from GymLikes l where l.userId = :userId and l.gymId = :gymId", GymLikes.class)
                .setParameter("userId", userId)
                .setParameter("gymId", gymId)
                .getSingleResult();
    }

    public List<GymLikes> findGymLikesByUserId(Long userId) {
        return em.createQuery("select l from LikeGym l where l.user.id = :userId", GymLikes.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<GymLikes> findGymLikesByGymId(Long gymId) {
        return em.createQuery("select l from LikeGym l where l.gym.id = :gymId", GymLikes.class)
                .setParameter("gymId", gymId)
                .getResultList();
    }
}
