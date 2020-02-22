package com.github.aman.SpringCRUD.resource;

import com.github.aman.SpringCRUD.model.Student;
import com.github.aman.SpringCRUD.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentResource {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getAllStudent")
    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();

    }
    @GetMapping("/getStudent")
    public Optional<Student> getStudent(@RequestParam(value="id", defaultValue = "0") String id){
        return studentRepository.findById(Integer.parseInt(id));
    }

    @GetMapping("/getStudentByName")
    public Iterable<Student> findStudentByName(@RequestParam(value="name", defaultValue = "Aman") String name){
//        @RequestParam(value="name", defaultValue = "") String name
        return studentRepository.findStudentByName(name);
    }

    @PostMapping("/addStudent")
    public Iterable<Student> addStudent(@RequestBody Student student){
        studentRepository.save(student);
        return studentRepository.findAll();
    }
}
