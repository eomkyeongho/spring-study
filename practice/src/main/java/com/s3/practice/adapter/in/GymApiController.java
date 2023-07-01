package com.s3.practice.adapter.in;

import com.s3.practice.domain.Gym;
import com.s3.practice.application.service.GymService;
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

        gymService.register(gym);

        return new CreateGymResponse("success");
    }

    @GetMapping("/api/v1/gyms/{gymId}")
    public RetrieveGymResponse retrieveGym(@PathVariable("gymId") Long gymId) {
        Gym gym = gymService.findById(gymId);

        return new RetrieveGymResponse(gym.getId(), gym.getName());
    }

    @Data
    static class CreateGymRequest {
        private String name;
    }

    @Data
    static class CreateGymResponse {
        private String result;

        public CreateGymResponse(String id) {
            this.result = result;
        }
    }

    @Data
    class RetrieveGymResponse {
        private Long id;
        private String name;

        public RetrieveGymResponse(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
