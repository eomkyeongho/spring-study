package com.s3.practice.adapter.out;

import com.s3.practice.adapter.out.jpa.VideoJpaRepository;
import com.s3.practice.application.port.out.UpdateVideoPort;
import com.s3.practice.domain.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateVideoPersistenceAdapter implements UpdateVideoPort {

    private final VideoJpaRepository videoJpaRepository;

    @Override
    public void save(Video video) {
        videoJpaRepository.save(video);
    }

    @Override
    public void delete(Video video) {
        videoJpaRepository.delete(video);
    }
}
