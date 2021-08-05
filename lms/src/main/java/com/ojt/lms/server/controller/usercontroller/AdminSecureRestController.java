package com.ojt.lms.server.controller.usercontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.ojt.lms.server.model.dto.Role;
import com.ojt.lms.server.model.dto.User;
import com.ojt.lms.server.repo.RoleRepository;
import com.ojt.lms.server.service.UserHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * todo Controller by Admin Role
 */
@RestController
@Api(tags = "User - for Admin")
@RequestMapping(value = "/api/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class AdminSecureRestController {
    @NonNull
    UserHandler service;
    @NonNull
    RoleRepository roleRepo;
    ObjectMapper objectMapper = new ObjectMapper();

    @ApiOperation(value = "get list role")
    @GetMapping("/get-roles")
    List<Role> getRoles() {
        return (List<Role>) roleRepo.findAll();
    }
    @ApiOperation(value = "get list role")
    @GetMapping("/role")
    ResponseEntity<Role> getRoles(@PathVariable("id") Long id) {
        return roleRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ApiOperation(value = "get user by id")
    @GetMapping("/get")
    ResponseEntity<User> getEditData(@RequestParam("id") Long id) {
        return service.retrieveUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).build());
    }

    @ApiOperation(value = "search user by any string,otherwise throws 404")
    @GetMapping("/search")
    ResponseEntity<List<User>> retrieveUser(@RequestParam("search") String search) {
        return service.retrievedUser(search).stream()
                .filter(list -> !list.isEmpty())
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).build());
    }

    @ApiOperation(value = "get list user")
    @GetMapping("/list")
    List<User> getUser() {
        return service.retrievedAllUser();
    }

    @ApiOperation(value = "request user with modified field," +
                                " then server update user")
    @PatchMapping(value = "/update", consumes = "application/json-patch+json")
    ResponseEntity<User> updateUser(@RequestBody JsonPatch patch,
                                    @PathVariable Long idUser) {
        try {
            var user = service.retrieveUserById(idUser).orElseThrow(() ->
                    new IllegalArgumentException("Cant find User: " + idUser));
            User _user = applyPatchToUser(patch, user);
            service.updateUser(_user);
            return ResponseEntity.ok(_user);
        } catch(JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private User applyPatchToUser(JsonPatch patch, User user)
            throws JsonPatchException, JsonProcessingException {
        var node = objectMapper.convertValue(user, JsonNode.class);
        JsonNode patched = patch.apply(node);
        return objectMapper.treeToValue(patched, User.class);
    }

    @ApiOperation(value = "admin ban user by modified enable/disable field")
    @PostMapping("/enabled")
    void updateEnabledUser(@RequestParam("id") Long id,
                           @RequestParam("enable") boolean enable) {
        service.updateStatus(id, enable);
    }

    @ApiOperation(value = "delete user from db")
    @DeleteMapping("/delete")
    void deleteUser(@RequestParam("id") Long id) {
        service.deletedUser(id);
    }

}

