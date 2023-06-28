package com.s3.practice.repository;

import com.s3.practice.domain.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VideoRepository {

    private final EntityManager em;

    public Long save(Video video) {
        em.persist(video);
        return video.getId();
    }

    public Long delete(Video video) {
        em.remove(video);
        return video.getId();
    }

    public Video findOne(Long id) {
        return em.find(Video.class, id);
    }

    public List<Video> findAll() {
        return em.createQuery("select v from Video v", Video.class)
                .getResultList();
    }

    public List<Video> findByUserId(Long userId) {
        return em.createQuery("select v from Video v where v.user.id = :userId", Video.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<Video> findByGymId(Long gymId) {
        return em.createQuery("select v from Video v where v.gym.id = :gymId", Video.class)
                .setParameter("gymId", gymId)
                .getResultList();
    }
}
