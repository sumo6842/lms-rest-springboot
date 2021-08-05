package com.ojt.lms.server.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ojt.lms.server.model.dto.Video;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class VideoDetail {
    Video video;
    @JsonProperty("id")
    Integer getId(){
        return video.getVideoID();
    }

    @JsonProperty("title")
    String getTitle() {
        return video.getVideoTitle();
    }

    @JsonProperty("Url")
    String getUrl() {
        return video.getVideoURL();
    }



}
