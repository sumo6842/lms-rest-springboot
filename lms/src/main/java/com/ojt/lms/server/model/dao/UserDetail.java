package com.ojt.lms.server.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ojt.lms.server.model.dto.Role;
import com.ojt.lms.server.model.dto.User;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserDetail implements UserDetails {
    User user;

    public UserDetail(User user) {
        this.user = user;
    }
    @JsonProperty("role")
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRole().stream()
                .map(Role::getRoleName)
                .map(SimpleGrantedAuthority::new)
                .collect(toList());
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @JsonProperty("username")
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty("status")
    @Override
    public boolean isEnabled() {
        return user.isEnable();
    }

    @JsonProperty("fullname")
    public String fullName() {
        return user.getFirstName() + " " + user.getLastName();
    }

    @JsonProperty("created_course")
    public List<CourseDetail> courses() {
        return user
                .getCreateCourse()
                .stream()
                .map(CourseDetail::new)
                .collect(toList());
    }

    @JsonProperty("enrolled_course")
    public List<CourseDetail> enrolledCourse() {
        return user.getEnrolledCourse()
                .stream()
                .filter(Objects::nonNull)
                .findFirst()
                .map(CourseDetail::new)
                .stream().collect(toList());
    }

//    @JsonProperty("role")
//    Long getIdRole() {
//        return user.getRole().get(0).getId();
//    }
}
