package com.s3.practice.application.port.in;

import com.s3.practice.domain.VideoComment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface VideoCommentUseCase {

    void leave(VideoComment videoComment);

    void delete(VideoComment videoComment);

    VideoComment findById(Long id);

    List<VideoComment> findVideoCommentsByVideoId(Long videoId);

    List<VideoComment> findVideoCommentsByUserId(Long userId);
}
