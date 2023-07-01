package com.s3.practice.application.port.out;

import com.s3.practice.domain.VideoComment;

public interface UpdateVideoCommentPort {
    void save(VideoComment videoComment);

    void delete(VideoComment videoComment);
}
