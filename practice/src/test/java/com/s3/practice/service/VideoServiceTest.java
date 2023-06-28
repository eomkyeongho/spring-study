package com.s3.practice.service;

import com.s3.practice.domain.Video;
import com.s3.practice.repository.VideoRepository;
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
class VideoServiceTest {

    @Autowired VideoService videoService;
    @Autowired VideoRepository videoRepository;

    @Test
    public void 비디오_업로드_삭제() {
        Video video = new Video();

        videoService.upload(video);
        Video findVideo = videoRepository.findOne(video.getId());

        assertEquals(findVideo.getId(), video.getId());

        videoService.delete(video);
        Video findVideo2 = videoRepository.findOne(video.getId());

        assertNull(findVideo2);
    }
}