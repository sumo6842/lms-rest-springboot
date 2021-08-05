package com.ojt.lms.server.controller;

import com.ojt.lms.server.model.dao.TopicDetail;
import com.ojt.lms.server.model.dao.VideoDetail;
import com.ojt.lms.server.repo.TopicHandler;
import com.ojt.lms.server.service.VideoHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RestController
@Api(tags = "Video")
@RequestMapping("/api/topic")
public class VideoController {
    @NonNull
    VideoHandler service;

    @ApiOperation(value = "Video")
    @GetMapping("/video/{id}")
    public ResponseEntity<List<VideoDetail>> getTopic(@PathVariable("id") String id) {
        try {
            var response = service.getVideo(id)
                    .stream()
                    .findAny()
                    .orElseThrow(NoSuchElementException::new)
                    .stream()
                    .map(VideoDetail::new)
                    .collect(toList());
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }
}