package com.s3.practice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter @Setter
public class Video {

    @Id @GeneratedValue
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String videoUrl;

    private String description;

    private String thumbnailUrl;

    private String category;

    private String level;

    @JoinColumn(name = "user_id")
    private Long userId;

    @JoinColumn(name = "gym_id")
    private Long gymId;
}
