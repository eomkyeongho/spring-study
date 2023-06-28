package com.s3.practice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class GymLikes {
    @Id @GeneratedValue
    @Column(name = "gym_likes_id")
    private Long id;

    @JoinColumn(name = "user_id")
    private Long userId;

    @JoinColumn(name = "gym_id")
    private Long gymId;
}
