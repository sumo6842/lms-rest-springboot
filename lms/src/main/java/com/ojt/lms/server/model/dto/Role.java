package com.ojt.lms.server.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "role")
@FieldDefaults(level = PRIVATE)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    Long id;

    @JsonProperty("name")
    String roleName;

    @JsonProperty("description")
    String roleDescription;

    @JsonIgnore
    @ManyToMany(mappedBy = "role")
    List<User> users = new ArrayList<>();

    public Role(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return String.format("%4d|%10s|%10s", id, roleName, roleDescription);
    }
}
