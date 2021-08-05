package com.ojt.lms.server.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "document")
@FieldDefaults(level = PRIVATE)
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer documentID;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    Topic topic;//Foreign key table topic

    @Column(name = "date")
    LocalDate dateTime;

    @Column(name = "content")
    byte[] content;
    String name;
    Long size;

    public Document(LocalDate dateTime, byte[] file) {
        this.dateTime = dateTime;
        this.content = file;
    }

    @Override
    public String toString() {
        return "Document{" +
                ", dateTime=" + dateTime +
                ", file=" + Arrays.toString(content) +
                '}';
    }
}
