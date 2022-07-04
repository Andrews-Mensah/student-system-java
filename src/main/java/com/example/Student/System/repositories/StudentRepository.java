package com.example.Student.System.repositories;

import com.example.Student.System.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long> {
    void deleteStudentById(Long id);

    Optional<Student> findStudentByEmail(String email);

    Student findStudentById(Long id);


}
