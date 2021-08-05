package com.ojt.lms.server.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "quiz")
@FieldDefaults(level = PRIVATE)
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer quizID;
    String quizName;
    Integer timeToDo;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    Topic topic;    //Foreign key table topic

    @OneToMany(mappedBy = "quiz")
    List<QuizBanking> quizBanking = new ArrayList<>();

    public Quiz(String quizName, Integer timeToDo) {
        this.quizName = quizName;
        this.timeToDo = timeToDo;
    }
}
