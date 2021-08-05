package com.ojt.lms.server.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ojt.lms.server.model.dto.Question;
import com.ojt.lms.server.model.dto.QuizBanking;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class QuizBankingDetail {
    @NonNull QuizBanking banking;

//    @JsonProperty("quiz")
//    List<Question> questionList() {
////        return banking.getQuestionOfQuiz();
//    }

}
