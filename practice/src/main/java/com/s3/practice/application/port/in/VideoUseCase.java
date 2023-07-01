package com.s3.practice.application.port.in;

import com.s3.practice.domain.Video;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface VideoUseCase {
    void upload(Video video);

    void delete(Video video);

    Video findById(Long id);

    List<Video> findAll();

    List<Video> findByUserId(Long userId);

    List<Video> findByGymId(Long gymId);
}
