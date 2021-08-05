package com.ojt.lms.server.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ojt.lms.server.model.dto.Assignment;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AssignmentDetail {
    Assignment ass;

    @JsonProperty("name")
    String getName() {
        return ass.getAssignmentTitle();
    }
    @JsonProperty("id")
    Integer getId() {
        return ass.getAssignmentID();
    }

}
