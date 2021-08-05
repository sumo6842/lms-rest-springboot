package com.ojt.lms.server.controller.coursecontroller;

import com.ojt.lms.server.model.dao.CourseDetail;
import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.service.CourseHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@Api(tags = "Course")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/api/course")
public class CourseRestController {
    @NonNull
    CourseHandler service;

    @ApiOperation(value = "get list course")
    @GetMapping("/subject/{id}")
    public ResponseEntity<List<CourseDetail>> getCourseBySubject(@PathVariable("id") Long id) {
        try {
            var collect = service.retrieveAllCourseBySubject(id)
                    .stream()
                    .filter(list -> !list.isEmpty())
                    .findFirst().orElseThrow(IllegalArgumentException::new)
                    .stream()
                    .map(CourseDetail::new)
                    .collect(toList());
            return ResponseEntity.ok(collect);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }

    @ApiOperation(value = "get list course by create user")
    @GetMapping("/user/{id}")
    public ResponseEntity<List<CourseDetail>> userCourse(@PathVariable("id") Long userId) {
        try {
            var collect = service.retrieveAllCourseByCreatedUser(userId)
                    .stream()
                    .filter(list -> !list.isEmpty())
                    .findFirst().orElseThrow(IllegalArgumentException::new)
                    .stream()
                    .map(CourseDetail::new)
                    .collect(toList());
            return ResponseEntity.ok(collect);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }
    @ApiOperation(value = "search course")
    @GetMapping("/search")
    public ResponseEntity<List<CourseDetail>> searchCourse(@RequestParam("search") String search) {
        try {
            var collect = service.retrieveBySearch(search)
                    .stream()
                    .filter(list -> !list.isEmpty())
                    .findFirst().orElseThrow(IllegalArgumentException::new)
                    .stream()
                    .map(CourseDetail::new)
                    .collect(toList());
            return ResponseEntity.ok(collect);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }
    @ApiOperation(value = "get course by Id")
    @GetMapping("/get")
    public ResponseEntity<CourseDetail> getCourseById(@RequestParam("courseId") String id) {
        try {
            return service.retrievedCourse(id)
                    .map(CourseDetail::new)
                    .map(ResponseEntity::ok)
                    .orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }


}
