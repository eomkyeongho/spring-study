package com.s3.practice.service;

import com.s3.practice.domain.Video;
import com.s3.practice.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    @Transactional
    public Long upload(Video video) {
        return videoRepository.save(video);
    }

    @Transactional
    public Long delete(Video video) {
        return videoRepository.delete(video);
    }

    public Video findOne(Long id) {
        return videoRepository.findOne(id);
    }
}
