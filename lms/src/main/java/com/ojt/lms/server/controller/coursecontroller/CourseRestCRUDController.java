package com.ojt.lms.server.controller.coursecontroller;

import com.ojt.lms.server.model.dao.UserDetail;
import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.service.CourseHandler;
import com.ojt.lms.server.service.UserHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@Api(tags = "Build Course")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/api/build-course")
public class CourseRestCRUDController {
    @NonNull
    CourseHandler service;
    @NonNull
    UserHandler userService;

    @ApiOperation(value = "delete course | dont use this")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable("id") String id) {
        service.deleteCourse(id);
        return ResponseEntity.ok().build();
    }
    @ApiOperation(value = "create course")
    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestParam("userId") Long userId,
                                               @RequestParam("subjectId") Long subjectId) {
        return service.createOrUpdateCourse(userId, subjectId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(INTERNAL_SERVER_ERROR).build());
    }

    @ApiOperation(value = "student enroll course")
    @GetMapping("/student/{courseId}")
    public ResponseEntity<List<UserDetail>> getStudentEnrolled(@PathVariable("courseId") String courseId) {
       try {
           var collect = userService.getAllUserEnrolledCourse(courseId)
                   .stream()
                   .filter(list -> !list.isEmpty())
                   .findFirst()
                   .orElseThrow(IllegalArgumentException::new)
                   .stream()
                   .map(UserDetail::new)
                   .collect(toList());
           return ResponseEntity.ok(collect);
       } catch (IllegalArgumentException e) {
           return ResponseEntity.status(NOT_FOUND).build();
       }
    }

}
