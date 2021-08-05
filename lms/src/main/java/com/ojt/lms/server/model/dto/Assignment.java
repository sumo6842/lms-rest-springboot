package com.ojt.lms.server.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "assignment")
@FieldDefaults(level = PRIVATE)
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer assignmentID;

    @Column(name = "title", nullable = false)
    String assignmentTitle;

    @Column(name = "content")
    byte[] content;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    Topic topic;    //Foreign key table topic

    @OneToMany(mappedBy = "assignment",orphanRemoval = true)
    List<AsmSubmission> asmSubs;
    Long size;

    public Assignment(String assignmentTitle, byte[] file) {
        this.assignmentTitle = assignmentTitle;
        this.content = file;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentID=" + assignmentID +
                ", assignmentTitle='" + assignmentTitle + '\'' +
                '}';
    }

}
