package com.s3.practice.adapter.out.jpa;

import com.s3.practice.domain.VideoComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoCommentJpaRepository extends JpaRepository<VideoComment, Long> {

    List<VideoComment> findByVideoId(Long videoId);
    List<VideoComment> findByUserId(Long userId);
}
