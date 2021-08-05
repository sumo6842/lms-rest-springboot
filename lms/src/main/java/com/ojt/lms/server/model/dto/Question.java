package com.ojt.lms.server.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "question")
@FieldDefaults(level = PRIVATE)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer questionID;

    @OneToMany(mappedBy = "questionOfQuiz")

    List<QuizBanking> quizBanking  = new ArrayList<>();  //Foreign key table subject

    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;


    String question;
    byte[] content;
    String correctAns;

    public Question(String question, String correctAns, byte[] content) {
        this.question = question;
        this.content = content;
        this.correctAns = correctAns;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", question='" + question + '\'' +
                ", content=" + Arrays.toString(content) +
                ", correctAns='" + correctAns + '\'' +
                '}';
    }
}
