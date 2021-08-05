package com.ojt.lms.server.controller;

import com.ojt.lms.server.model.dto.Assignment;
import com.ojt.lms.server.service.AssignmentHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Api(tags = "Assignment")
@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {
    @NonNull
    AssignmentHandler service;

    @ApiOperation(value = "create assignment")
    @PostMapping("/create")
    ResponseEntity createAssignment(@PathParam("idTopic") Long idTopic,
                                  @RequestParam MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        var Assignment = new Assignment(filename, file.getBytes());
        Assignment.setSize(file.getSize());
        service.createOrUpdateAssignment(idTopic, Assignment);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "download assignment")
    @GetMapping("/download")
    ResponseEntity<byte[]> getFile(@Param("id") Integer id) {
        try {
            return service.retrieveById(id)
                    .stream().findAny()
                    .stream()
                    .map(d -> ResponseEntity
                            .ok().header("Content-Disposition", "attachment;filename" + d.getAssignmentTitle())
                            .contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(d.getContent()))
                    .findAny()
                    .orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }

}
