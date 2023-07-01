package com.s3.practice.application.port.out;

import com.s3.practice.domain.Gym;

public interface UpdateGymPort {
    void save(Gym gym);
}
