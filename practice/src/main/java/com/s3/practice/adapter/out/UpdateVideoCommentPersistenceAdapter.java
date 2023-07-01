package com.s3.practice.adapter.out;

import com.s3.practice.adapter.out.jpa.VideoCommentJpaRepository;
import com.s3.practice.application.port.out.UpdateVideoCommentPort;
import com.s3.practice.domain.VideoComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateVideoCommentPersistenceAdapter implements UpdateVideoCommentPort {

    private final VideoCommentJpaRepository videoCommentJpaRepository;

    @Override
    public void save(VideoComment videoComment) {
        videoCommentJpaRepository.save(videoComment);
    }

    @Override
    public void delete(VideoComment videoComment) {
        videoCommentJpaRepository.delete(videoComment);
    }
}
