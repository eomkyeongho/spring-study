package com.s3.practice.repository;

import com.s3.practice.domain.VideoComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VideoCommentRepository {

    private final EntityManager em;

    public Long save(VideoComment videoComment) {
        em.persist(videoComment);
        return videoComment.getId();
    }

    public Long delete(VideoComment videoComment) {
        em.remove(videoComment);
        return videoComment.getId();
    }

    public VideoComment findOne(Long id) {
        return em.find(VideoComment.class, id);
    }

    public List<VideoComment> findByVideoId(Long videoId) {
        return em.createQuery("select c from VideoComment c where c.video.id = :videoId", VideoComment.class)
                .setParameter("videoId", videoId)
                .getResultList();
    }

    public List<VideoComment> findByUserId(Long userId) {
        return em.createQuery("select c from VideoComment c where c.user.id = :userId", VideoComment.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
