package com.ojt.lms.server.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ojt.lms.server.model.dto.Document;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class DocumentDetail {
    Document document;

    @JsonProperty("id")
    Integer getId() {return document.getDocumentID();}

    @JsonProperty("name")
    String getName() {return document.getName();}

    @JsonProperty("date")
    LocalDate get() {return document.getDateTime();}

}
