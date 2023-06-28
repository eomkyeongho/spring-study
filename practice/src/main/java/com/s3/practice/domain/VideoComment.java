package com.s3.practice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Getter @Setter
public class VideoComment {
    @Id @GeneratedValue
    private Long id;

    @JoinColumn(name = "user_id")
    private Long userId;

    @JoinColumn(name = "video_id")
    private Long videoId;

    private String content;

    private Long parentCommentId;
}
