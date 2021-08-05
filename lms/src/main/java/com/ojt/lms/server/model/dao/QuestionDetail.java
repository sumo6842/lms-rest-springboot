package com.ojt.lms.server.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import com.ojt.lms.server.model.dto.Question;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class QuestionDetail {
    Question question;

    @JsonProperty("Question")
    String getQuestion() {
        return question.getQuestion();
    }
    @JsonProperty("Answer")
    List<String> getAnswer() {
        var content = new String(question.getContent());
        var ans = Arrays.stream(content.split("\\."))
                .collect(toList());
        return ans;
    }
    @JsonProperty("correct")
    String getCorrectAns() {
        return question.getCorrectAns();
    }

    @Override
    public String toString() {
        return String.format("%4d|%20s|%25s", question.getQuestionID(),
                question.getQuestion(), new String(question.getContent()));
    }
}
