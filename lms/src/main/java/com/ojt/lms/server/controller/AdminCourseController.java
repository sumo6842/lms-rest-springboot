package com.ojt.lms.server.controller;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.service.CourseHandler;
import com.ojt.lms.server.service.SubjectHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@Api(tags = "subject")
@RequestMapping(value = "/api/admin")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class AdminCourseController {
    @NonNull SubjectHandler subjectHandler;
    @NonNull CourseHandler courseHandler;
    @ApiOperation(value = "get subject by id")
    @GetMapping("/subject/{id}")
    public ResponseEntity<List<Course>> getCourse(
            @PathVariable("id") Long subjectId) {
        try {
            var collect = courseHandler.retrieveAllCourseBySubject(subjectId)
                    .stream()
                    .findAny()
                    .orElseThrow(NoSuchElementException::new)
                    .stream().collect(toList());
            return ResponseEntity.ok(collect);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }

}
