package com.ojt.lms.server.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "quizbanking")
@FieldDefaults(level = PRIVATE)
public class QuizBanking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer quizBankingID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "question_id")
    Question questionOfQuiz;

    String correctAnw;

}
