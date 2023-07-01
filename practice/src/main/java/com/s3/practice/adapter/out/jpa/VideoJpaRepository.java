package com.s3.practice.adapter.out.jpa;

import com.s3.practice.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoJpaRepository extends JpaRepository<Video, Long> {

    List<Video> findByUserId(Long userId);
    List<Video> findByGymId(Long gymId);
}
