package com.ojt.lms.server.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "video")
@FieldDefaults(level = PRIVATE)
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer videoID;

    String videoURL;
    String videoTitle;
    boolean isSeen = false;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    public Video(String videoURL, String videoTitle) {
        this.videoURL = videoURL;
        this.videoTitle = videoTitle;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoID=" + videoID +
                ", videoURL='" + videoURL + '\'' +
                ", videoTitle='" + videoTitle + '\'' +
                ", isSeen=" + isSeen +
                '}';
    }
}
