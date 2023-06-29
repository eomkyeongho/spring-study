package com.s3.practice.api;

import com.s3.practice.domain.Video;
import com.s3.practice.service.VideoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class VideoApiController {

    private final VideoService videoService;

    @PostMapping("/api/v1/videos")
    public CreateVideoResponse saveVideo(@RequestBody CreateVideoRequest request) {
        Video video = new Video();
        video.setTitle(request.getTitle());
        video.setVideoUrl(request.getVideoUrl());

        Long id = videoService.upload(video);

        return new CreateVideoResponse(id);
    }

    @GetMapping("/api/v1/videos/{videoId}")
    public RetrieveVideoResponse retrieveVideo(@PathVariable("videoId") Long videoId) {
        Video video = videoService.findOne(videoId);

        return new RetrieveVideoResponse(video.getId(), video.getTitle(), video.getVideoUrl());
    }

    @Data
    static class CreateVideoRequest {
        private String title;
        private String VideoUrl;
    }

    @Data
    static class CreateVideoResponse {
        private Long id;

        public CreateVideoResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class RetrieveVideoResponse {
        private Long id;
        private String title;
        private String videoUrl;

        public RetrieveVideoResponse(Long id, String title, String videoUrl) {
            this.id = id;
            this.title = title;
            this.videoUrl = videoUrl;
        }
    }
}
