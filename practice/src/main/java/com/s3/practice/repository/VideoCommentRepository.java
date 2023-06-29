package com.s3.practice.repository;

import com.s3.practice.domain.VideoComment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VideoCommentRepository {

    private final VideoCommentJpaRepository videoCommentJpaRepository;

    public void save(VideoComment videoComment) {
        videoCommentJpaRepository.save(videoComment);
    }

    public void delete(VideoComment videoComment) {
        videoCommentJpaRepository.delete(videoComment);
    }

    public Optional<VideoComment> findOne(Long id) {
        return videoCommentJpaRepository.findById(id);
    }

    public List<VideoComment> findByVideoId(Long videoId) {
        return videoCommentJpaRepository.findByVideoId(videoId);
    }

    public List<VideoComment> findByUserId(Long userId) {
        return videoCommentJpaRepository.findByUserId(userId);
    }
}
