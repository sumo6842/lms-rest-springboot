package com.ojt.lms.server.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ojt.lms.server.model.dto.Assignment;
import com.ojt.lms.server.model.dto.Topic;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TopicDetail {
    Topic topic;

    @JsonProperty("id")
    Long getId() {
        return this.topic.getTopicID();
    }

    @JsonProperty("title")
    String description() {
        return topic.getTopicTitle();
    }

    @JsonProperty("document")
    List<DocumentDetail> getDocument() {
        return topic.getDocuments()
                .stream()
                .map(DocumentDetail::new)
                .collect(toList());
    }

    @JsonProperty("assignment")
    List<AssignmentDetail> getAssignment() {
        return topic.getAssignments()
                .stream()
                .map(AssignmentDetail::new)
                .collect(toList());
    }



}
