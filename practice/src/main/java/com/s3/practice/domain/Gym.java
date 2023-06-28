package com.s3.practice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Gym {
    @Id @GeneratedValue
    @Column(name = "gym_id")
    private Long id;
    private String name;
    private float coordinateX;
    private float coordinateY;
}