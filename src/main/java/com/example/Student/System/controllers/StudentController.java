package com.example.Student.System.controllers;

import com.example.Student.System.interfaces.StudentServiceInterface;
import com.example.Student.System.models.Student;
import com.example.Student.System.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }



    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students = studentService.students();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        Optional<Student> student = studentService.findStudentById(id);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<Student> getStudentByEmail(@RequestParam(name="email") String email){
        Optional<Student> student = studentService.findStudentByEmail(email);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @PostMapping("/add-student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent = studentService.addStudent(student);
        return new ResponseEntity(newStudent, HttpStatus.CREATED);
    }

    @PutMapping("/update-student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable ("id") Long id, @RequestBody Student student){

        Student updateStudent = studentService.updateStudent(id, student);
        return new ResponseEntity(updateStudent, HttpStatus.OK);
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }








}
