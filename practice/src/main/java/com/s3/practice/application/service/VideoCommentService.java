package com.s3.practice.application.service;

import com.s3.practice.adapter.out.LoadVideoCommentPersistenceAdapter;
import com.s3.practice.adapter.out.UpdateVideoCommentPersistenceAdapter;
import com.s3.practice.application.port.in.VideoCommentUseCase;
import com.s3.practice.domain.VideoComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VideoCommentService implements VideoCommentUseCase {

    private final LoadVideoCommentPersistenceAdapter lvp;
    private final UpdateVideoCommentPersistenceAdapter uvp;

    @Override
    @Transactional
    public void leave(VideoComment videoComment) {
        uvp.save(videoComment);
    }

    @Override
    @Transactional
    public void delete(VideoComment videoComment) {
        uvp.delete(videoComment);
    }

    @Override
    public VideoComment findById(Long id) {
        Optional<VideoComment> videoComment = lvp.findById(id);

        if(videoComment == null) {
            throw new IllegalStateException("존재하지 않는 댓글입니다.");
        }

        return videoComment.get();
    }

    @Override
    public List<VideoComment> findVideoCommentsByVideoId(Long videoId) {
        return lvp.findByVideoId(videoId);
    }

    @Override
    public List<VideoComment> findVideoCommentsByUserId(Long userId) {
        return lvp.findByUserId(userId);
    }
}
