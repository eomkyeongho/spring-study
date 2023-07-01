package com.s3.practice.adapter.out;

import com.s3.practice.adapter.out.jpa.VideoCommentJpaRepository;
import com.s3.practice.application.port.out.LoadVideoCommentPort;
import com.s3.practice.domain.VideoComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoadVideoCommentPersistenceAdapter implements LoadVideoCommentPort {

    private final VideoCommentJpaRepository videoCommentJpaRepository;

    @Override
    public Optional<VideoComment> findById(Long id) {
        return videoCommentJpaRepository.findById(id);
    }

    @Override
    public List<VideoComment> findByVideoId(Long videoId) {
        return videoCommentJpaRepository.findByVideoId(videoId);
    }

    @Override
    public List<VideoComment> findByUserId(Long userId) {
        return videoCommentJpaRepository.findByUserId(userId);
    }
}
