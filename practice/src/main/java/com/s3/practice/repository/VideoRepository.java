package com.s3.practice.repository;

import com.s3.practice.domain.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VideoRepository {

    private final VideoJpaRepository videoJpaRepository;

    public void save(Video video) {
        videoJpaRepository.save(video);
    }

    public void delete(Video video) {
        videoJpaRepository.delete(video);
    }

    public Optional<Video> findOne(Long id) {
        return videoJpaRepository.findById(id);
    }

    public List<Video> findAll() {
        return videoJpaRepository.findAll();
    }

    public List<Video> findByUserId(Long userId) {
        return videoJpaRepository.findByUserId(userId);
    }

    public List<Video> findByGymId(Long gymId) {
        return videoJpaRepository.findByGymId(gymId);
    }
}
