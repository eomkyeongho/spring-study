package com.s3.practice.service;

import com.s3.practice.domain.VideoComment;
import com.s3.practice.repository.VideoCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VideoCommentService {

    private final VideoCommentRepository videoCommentRepository;

    @Transactional
    public Long leave(VideoComment videoComment) {
        return videoCommentRepository.save(videoComment);
    }

    @Transactional
    public Long delete(VideoComment videoComment) {
        return videoCommentRepository.delete(videoComment);
    }

    public List<VideoComment> findVideoCommentsByVideoId(Long videoId) {
        return videoCommentRepository.findByVideoId(videoId);
    }
}
