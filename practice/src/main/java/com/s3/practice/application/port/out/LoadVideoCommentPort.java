package com.s3.practice.application.port.out;

import com.s3.practice.domain.VideoComment;

import java.util.List;
import java.util.Optional;

public interface LoadVideoCommentPort {
    Optional<VideoComment> findById(Long id);

    List<VideoComment> findByVideoId(Long videoId);

    List<VideoComment> findByUserId(Long userId);
}
