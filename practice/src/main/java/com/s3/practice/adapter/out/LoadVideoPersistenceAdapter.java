package com.s3.practice.adapter.out;

import com.s3.practice.adapter.out.jpa.VideoJpaRepository;
import com.s3.practice.application.port.out.LoadVideoPort;
import com.s3.practice.domain.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoadVideoPersistenceAdapter implements LoadVideoPort {

    private final VideoJpaRepository videoJpaRepository;

    @Override
    public Optional<Video> findById(Long id) {
        return videoJpaRepository.findById(id);
    }

    @Override
    public List<Video> findAll() {
        return videoJpaRepository.findAll();
    }

    @Override
    public List<Video> findByUserId(Long userId) {
        return videoJpaRepository.findByUserId(userId);
    }

    @Override
    public List<Video> findByGymId(Long gymId) {
        return videoJpaRepository.findByGymId(gymId);
    }
}
