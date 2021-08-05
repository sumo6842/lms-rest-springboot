package com.ojt.lms.server.controller.subjectcontroller;

import com.ojt.lms.server.model.dao.SubjectDetail;
import com.ojt.lms.server.service.CourseHandler;
import com.ojt.lms.server.service.subject_impl.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Api(tags = "Subject")
@RestController
@RequestMapping("/api/subjects")
public class SubjectRestController {
    @NonNull
    SubjectService service;
    @NonNull
    CourseHandler courseService;

    @ApiOperation(value = "get list subject")
    @GetMapping("/get-subject")
    public List<SubjectDetail> getSubject() {
        return service.retrieveAllSubject()
                .stream()
                .peek(s -> s.setCourses(courseService.retrieveAllCourseBySubject(s.getId()).get()))
                .map(SubjectDetail::new)
                .collect(toList());

    }

}
