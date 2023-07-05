package com.s3.practice.application.service;

import com.s3.practice.application.port.out.LoadGymLikePort;
import com.s3.practice.application.port.out.LoadGymPort;
import com.s3.practice.application.port.out.UpdateGymLikePort;
import com.s3.practice.application.port.out.UpdateGymPort;
import com.s3.practice.domain.Gym;
import com.s3.practice.domain.GymLike;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GymServiceTest {

    GymService gymService;
    UpdateGymPort updateGymPort= new TestUpdateGymPort();
    @Mock LoadGymPort loadGymPort;
    List<Gym> gymRepository = new ArrayList<>();
    @BeforeEach
    void setUp() {
        gymService = new GymService(updateGymPort, loadGymPort);
        gymRepository.clear();
    }

    @Test
    @DisplayName("등록")
    void register() {
        // given
        Gym gym = Gym.builder()
                .name("암장1")
                .build();

        // when
        gymService.register(gym);

        // then
        Gym sut = gymRepository.get(0);
        assertThat(gymRepository.size()).isEqualTo(1);
        assertThat(sut.getName()).isEqualTo("암장1");
    }

    @Test
    @DisplayName("조회")
    void findById() {
        // given
        Gym gym = Gym.builder()
                .name("암장1")
                .build();

        given(loadGymPort.findById(1L))
                .willReturn(Optional.ofNullable(gym));
        // when
        Gym sut = gymService.findById(1L);

        // then
        then(loadGymPort).should(Mockito.times(1)).findById(1L);
        assertThat(sut.getName()).isEqualTo("암장1");
    }
    private class TestUpdateGymPort implements UpdateGymPort {
        @Override
        public void save(Gym gym) {
            gymRepository.add(gym);
        }

    }
}