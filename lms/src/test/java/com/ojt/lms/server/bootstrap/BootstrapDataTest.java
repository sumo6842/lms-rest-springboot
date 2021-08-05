package com.ojt.lms.server.bootstrap;

import com.ojt.lms.server.model.dto.Role;
import com.ojt.lms.server.model.dto.Subject;
import com.ojt.lms.server.repo.RoleRepository;
import com.ojt.lms.server.repo.SubjectRepository;
import com.ojt.lms.server.repo.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.List;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class BootstrapDataTest {

    UserRepository userRepository;
    RoleRepository roleRepository;
    SubjectRepository subjectRepository;
    TestEntityManager em;

    @Autowired
    public BootstrapDataTest(UserRepository userRepository,
                             RoleRepository roleRepository,
                             SubjectRepository subjectRepository, TestEntityManager em) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.subjectRepository = subjectRepository;
        this.em = em;
    }

    List<Role> roles = Arrays.asList(
            new Role("Admin", "System Management and Academic Manager Management"),
            new Role("AcademicManager", "Teacher Management and Student Management"),
            new Role("Student", "Enrol or Unenrol and course grade, Take test and do it, Submit of Assignment Management"),
            new Role("Teacher", "Course Management, Student Management,Bank quiz Management, Submission of Assignment Management")
    );

    List<Subject> subjects = Arrays.asList(
            new Subject("PRO192", "Java Basic"),
            new Subject("PRF192", "C Basic"),
            new Subject("DBI202", "Database Introduction"),
            new Subject("PRJ301", "Java Web Application"),
            new Subject("CEA201", "Computer Organization and Architecture"),
            new Subject("CSI101", "Introduction to Computing"),
            new Subject("SWE102", "Introduction to Software Engineering"),
            new Subject("OSG202", "Operating System"),
            new Subject("MAD101", "Discrete mathematics"),
            new Subject("PRJ311", "Desktop Java Applications"),
            new Subject("SWD391", "Software Architecture and Design"),
            new Subject("PRX301", "Advanced XML for Java and Javascript")
    );

    @Test
    void bootstrapData() {
    }

    @Test
    void creatRoleTest() {
        this.roles.forEach(roleRepository::save);
    }

    @Test
    void createSubject() {
        this.subjects.forEach(subjectRepository::save);
    }

}
