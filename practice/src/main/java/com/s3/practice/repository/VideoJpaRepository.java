package com.s3.practice.repository;

import com.s3.practice.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoJpaRepository extends JpaRepository<Video, Long> {

    List<Video> findByUserId(Long userId);
    List<Video> findByGymId(Long gymId);
}
