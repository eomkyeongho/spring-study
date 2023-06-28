package com.s3.practice.repository;

import com.s3.practice.domain.VideoComment;
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
class VideoCommentRepositoryTest {

    @Autowired VideoCommentRepository videoCommentRepository;

    @Test
    public void 댓글_저장_삭제() throws Exception {
        // given
        VideoComment videoComment = new VideoComment();
        videoComment.setVideoId(1L);
        videoComment.setUserId(1L);
        videoComment.setContent("댓글A");

        // when
        Long savedId = videoCommentRepository.save(videoComment);
        VideoComment findVideoComment = videoCommentRepository.findOne(savedId);

        // then
        assertEquals(findVideoComment.getId(), videoComment.getId());

        // when
        videoCommentRepository.delete(findVideoComment);
        VideoComment findVideoComment2 = videoCommentRepository.findOne(savedId);

        // then
        assertNull(findVideoComment2);
    }
}