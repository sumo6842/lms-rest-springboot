package com.ojt.lms.server.service.subject_impl;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Video;
import com.ojt.lms.server.repo.CourseRepository;
import com.ojt.lms.server.repo.VideoRepository;
import com.ojt.lms.server.service.VideoHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor
public class VideoService implements VideoHandler {

    @NonNull
    VideoRepository repo;
    @NonNull
    CourseRepository courseRepository;
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Optional<List<Video>> getVideo(String courseId) {
        return Optional.of((List<Video>)em.createQuery("SELECT c.videos FROM Course c WHERE c.courseID = :id ")
                .setParameter("id", courseId)
                .getResultList());
    }

    @Override
    @Transactional
    public Optional<Video> addOrUpdate(String idCourse, Video video) {
        var course = courseRepository.findById(idCourse)
                .stream().findAny()
                .stream().peek(c -> c.getVideos().add(video))
                .findAny();
        video.setCourse(course.get());
        repo.save(video);
        return Optional.of(video);
    }
}
