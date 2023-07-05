package com.s3.practice.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class GymLike {
    @Id @GeneratedValue
    @Column(name = "gym_like_id")
    private Long id;

    @JoinColumn(name = "user_id")
    private Long userId;

    @JoinColumn(name = "gym_id")
    private Long gymId;

    @Builder
    public GymLike(Long userId, Long gymId) {
        this.userId = userId;
        this.gymId = gymId;
    }
}
