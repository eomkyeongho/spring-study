package com.s3.practice.repository;

import com.s3.practice.domain.Video;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class VideoRepositoryTest {

    @Autowired VideoRepository videoRepository;

    @Test
    public void 비디오_저장_삭제() {
        // given
        Video video = new Video();
        video.setTitle("영상A");

        // when
        Long savedId = videoRepository.save(video);
        Video findVideo = videoRepository.findOne(savedId);

        // then
        assertEquals(findVideo.getId(), video.getId());

        // when
        videoRepository.delete(findVideo);
        Video findVideo2 = videoRepository.findOne(savedId);

        // then
        assertNull(findVideo2);
    }
}