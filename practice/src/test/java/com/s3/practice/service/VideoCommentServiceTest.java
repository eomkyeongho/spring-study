package com.s3.practice.service;

import com.s3.practice.domain.VideoComment;
import com.s3.practice.repository.VideoCommentRepository;
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
class VideoCommentServiceTest {

    @Autowired VideoCommentService videoCommentService;
    @Autowired VideoCommentRepository videoCommentRepository;

    @Test
    public void 댓글_등록_삭제() throws Exception {
        VideoComment videoComment = new VideoComment();

        videoCommentService.leave(videoComment);
        VideoComment findVideoComment = videoCommentRepository.findOne(videoComment.getId());

        assertEquals(findVideoComment.getId(), videoComment.getId());

        videoCommentService.delete(videoComment);
        VideoComment findVideoComment2 = videoCommentRepository.findOne(videoComment.getId());

        assertNull(findVideoComment2);
    }
}