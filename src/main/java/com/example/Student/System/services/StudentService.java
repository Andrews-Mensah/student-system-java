package com.example.Student.System.services;

import com.example.Student.System.exceptions.StudentExceptions;
import com.example.Student.System.interfaces.StudentServiceInterface;
import com.example.Student.System.models.Student;
import com.example.Student.System.repositories.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Service
@Transactional
public class StudentService implements StudentServiceInterface {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    public List<Student> students;

    @Override
    public List<Student> students() {
       return (List<Student>) studentRepository.findAll();
    }

    public Student addStudent (Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student){
       Student student1 =  studentRepository.findStudentById(id);
        System.out.println(student1);
       student1.setEmail(student.getEmail());
        return studentRepository.save(student1);
    }



    public void deleteStudent(Long id){
        studentRepository.deleteStudentById(id);
    }

    public Optional<Student> findStudentByEmail(String email){
        return Optional.ofNullable(studentRepository.findStudentByEmail(email).orElseThrow(() -> new StudentExceptions("Student with email of" + " " + email + " " + "not found.")));
    }

    public Optional<Student> findStudentById(Long id){
        return Optional.ofNullable(studentRepository.findStudentById(id));
//                orElseThrow(() -> new StudentExceptions("Student with id of " + " " + id + " " + "not found.")));
    }



}
