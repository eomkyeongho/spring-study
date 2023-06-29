package com.s3.practice.api;

import com.s3.practice.domain.Gym;
import com.s3.practice.service.GymService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class GymApiController {

    private final GymService gymService;

    @PostMapping("/api/v1/gyms")
    public CreateGymResponse saveGym(@RequestBody @Valid CreateGymRequest request) {
        Gym gym = new Gym();
        gym.setName(request.getName());

        Long id = gymService.register(gym);

        return new CreateGymResponse(id);
    }

    @GetMapping("/api/v1/gyms/{gymId}")
    public RetrieveGymResponse retrieveGym(@PathVariable("gymId") Long gymId) {
        Gym gym = gymService.findOne(gymId);

        return new RetrieveGymResponse(gym.getId(), gym.getName());
    }

    @Data
    static class CreateGymRequest {
        private String name;
    }

    @Data
    static class CreateGymResponse {
        private Long id;

        public CreateGymResponse(Long id) {
            this.id = id;
        }
    }

    @Data class RetrieveGymResponse {
        private Long id;
        private String name;

        public RetrieveGymResponse(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
