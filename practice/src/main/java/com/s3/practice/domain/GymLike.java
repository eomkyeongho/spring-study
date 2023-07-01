package com.s3.practice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class GymLike {
    @Id @GeneratedValue
    @Column(name = "gym_like_id")
    private Long id;

    @JoinColumn(name = "user_id")
    private Long userId;

    @JoinColumn(name = "gym_id")
    private Long gymId;
}
