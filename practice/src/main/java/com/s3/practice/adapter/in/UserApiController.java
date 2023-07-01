package com.s3.practice.adapter.in;

import com.s3.practice.domain.User;
import com.s3.practice.application.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/users")
    public CreateUserResponse saveUser(@RequestBody @Valid CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.getName());

        userService.join(user);

        return new CreateUserResponse("success");
    }

    @GetMapping("/api/v1/users")
    public List<RetrieveUserResponse> retrieveAllUsers() {
        List<User> users = userService.findAll();

        return users.stream()
                .map(user -> new RetrieveUserResponse(user.getId(), user.getUsername(), user.getEmail()))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/v1/users/{userId}")
    public RetrieveUserResponse retrieveUser(@PathVariable("userId") Long userId) {
        User user = userService.findById(userId);

        return new RetrieveUserResponse(user.getId(), user.getUsername(), user.getEmail());
    }

    @Data
    static class CreateUserRequest {
        private String name;
    }

    @Data
    static class CreateUserResponse {
        private String result;

        public CreateUserResponse(String result) {
            this.result = result;
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
