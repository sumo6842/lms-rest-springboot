package com.ojt.lms.server.controller;

import com.ojt.lms.server.model.dto.Document;
import com.ojt.lms.server.service.DocumentHandler;
import com.ojt.lms.server.service.document.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.function.Function;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Api(tags = "Document")
@RestController
@RequestMapping("/api/document")
public class DocumentController {
    @NonNull
    DocumentHandler service;

    @ApiOperation(value = "create document")
    @PostMapping("/create")
    ResponseEntity createDocument(@PathParam("idTopic") Long idTopic,
                                  @RequestParam MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        var document = new Document(LocalDate.now(), file.getBytes());
        document.setName(filename);
        document.setSize(file.getSize());
        service.createOrUpdateDocument(idTopic, document);
        return ResponseEntity.ok().build();
    }
    @ApiOperation(value = "download document")
    @GetMapping("/download")
    ResponseEntity<byte[]> getFile(@Param("id") Integer id) {
        try {
            return service.retrieveById(id)
                    .stream().findAny()
                    .stream()
                    .map(d -> ResponseEntity
                            .ok().header("Content-Disposition", "attachment;filename" + d.getName())
                            .contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(d.getContent()))
                    .findAny()
                    .orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }

}
