package com.s3.practice.application.port.out;

import com.s3.practice.domain.GymLike;

public interface UpdateGymLikePort {
    void save(GymLike gymLike);

    void delete(GymLike gymLike);
}
