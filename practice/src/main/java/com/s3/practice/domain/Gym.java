package com.s3.practice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@NoArgsConstructor
public class Gym {
    @Id @GeneratedValue
    @Column(name = "gym_id")
    private Long id;

    @NotEmpty
    private String name;

    private float coordinateX;

    private float coordinateY;

    @Builder
    public Gym(String name, float coordinateX, float coordinateY) {
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }
}
