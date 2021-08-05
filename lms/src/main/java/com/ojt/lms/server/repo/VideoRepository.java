package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {
}
