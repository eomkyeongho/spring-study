package com.s3.practice.application.port.out;

import com.s3.practice.domain.Video;

import java.util.List;
import java.util.Optional;

public interface LoadVideoPort {
    Optional<Video> findById(Long id);

    List<Video> findAll();

    List<Video> findByUserId(Long userId);

    List<Video> findByGymId(Long gymId);
}
