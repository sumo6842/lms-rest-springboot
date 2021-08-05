package com.ojt.lms.server.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "asm_submission")
@FieldDefaults(level = PRIVATE)
public class AsmSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer assignmentSubmissionID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;    //Foreign key table user

    @ManyToOne
    @JoinColumn(name = "asm_id")
    Assignment assignment;   //Foreign key table assignment

    LocalDate dateTime;
    @Column(name = "content")
    byte[] file;
}
