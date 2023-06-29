package com.s3.practice.api;

import com.s3.practice.domain.User;
import com.s3.practice.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/users")
    public CreateUserResponse saveUser(@RequestBody @Valid CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.getName());

        Long id = userService.join(user);

        return new CreateUserResponse(id);
    }

    @GetMapping("/api/v1/users/{userId}")
    public RetrieveUserResponse retrieveUser(@PathVariable("userId") Long userId) {
        User user = userService.findOne(userId);

        return new RetrieveUserResponse(user.getId(), user.getUsername(), user.getEmail());
    }

    @Data
    static class CreateUserRequest {
        private String name;
    }

    @Data
    static class CreateUserResponse {
        private Long id;

        public CreateUserResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class RetrieveUserResponse {
        private Long id;
        private String name;
        private String email;

        public RetrieveUserResponse(Long id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }
    }
}
