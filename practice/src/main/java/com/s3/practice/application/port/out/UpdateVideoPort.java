package com.s3.practice.application.port.out;

import com.s3.practice.domain.Video;

public interface UpdateVideoPort {
    void save(Video video);

    void delete(Video video);
}
