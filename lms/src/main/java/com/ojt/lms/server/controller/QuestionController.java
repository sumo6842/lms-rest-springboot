package com.ojt.lms.server.controller;

import com.ojt.lms.server.model.dao.QuestionDetail;
import com.ojt.lms.server.model.dto.Question;
import com.ojt.lms.server.service.QuestionHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RestController
@Api(tags = "Question")
@RequestMapping("/api/question")
public class QuestionController {
    @NonNull
    QuestionHandler questionHandler;
    @ApiOperation(value = "get List Question subject")
    @GetMapping("/subject/{id}/get")
    ResponseEntity<List<QuestionDetail>> getQuestion(@PathVariable("id") Long id) {
        try {
            var collect = questionHandler.getQuestionFromSubject(id)
                    .stream().findAny()
                    .orElseThrow(IllegalArgumentException::new)
                    .stream()
                    .map(QuestionDetail::new)
                    .collect(Collectors.toList());
                    return ResponseEntity.ok(collect);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/quiz/{id}")
    ResponseEntity<List<QuestionDetail>> getQuestionForQuiz(@PathVariable("id") Integer id) {
        try {
            var collect = questionHandler.getQuestionToQuiz(id)
                    .stream().findAny()
                    .orElseThrow(IllegalArgumentException::new)
                    .stream()
                    .collect(Collectors.toList());
            return ResponseEntity.ok(collect);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
