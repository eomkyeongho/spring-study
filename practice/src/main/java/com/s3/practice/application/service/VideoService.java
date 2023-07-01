package com.s3.practice.application.service;

import com.s3.practice.adapter.out.LoadVideoPersistenceAdapter;
import com.s3.practice.adapter.out.UpdateVideoPersistenceAdapter;
import com.s3.practice.application.port.in.VideoUseCase;
import com.s3.practice.domain.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VideoService implements VideoUseCase {

    private final UpdateVideoPersistenceAdapter uvp;
    private final LoadVideoPersistenceAdapter lvp;

    @Override
    @Transactional
    public void upload(Video video) {
        uvp.save(video);
    }

    @Override
    @Transactional
    public void delete(Video video) {
        uvp.delete(video);
    }

    @Override
    public Video findById(Long id) {
        Optional<Video> video = lvp.findById(id);

        if(video == null) {
            throw new IllegalStateException("존재하지 않는 영상입니다.");
        }

        return video.get();
    }

    @Override
    public List<Video> findAll() {
        return lvp.findAll();
    }

    @Override
    public List<Video> findByUserId(Long userId) {
        return lvp.findByUserId(userId);
    }

    @Override
    public List<Video> findByGymId(Long gymId) {
        return lvp.findByGymId(gymId);
    }
}
