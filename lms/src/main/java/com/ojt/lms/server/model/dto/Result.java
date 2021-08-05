package com.ojt.lms.server.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "result")
@FieldDefaults(level = PRIVATE) class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer resultID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User userID;    //Foreign key table user

    @ManyToOne
    @JoinColumn(name = "quiz_banking_id")
    QuizBanking quizBankingID;  //Foreign key table quizbanking

    String resultOption;
}
