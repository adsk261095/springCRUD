package com.github.aman.SpringCRUD.resource;

import com.github.aman.SpringCRUD.model.Student;
import com.github.aman.SpringCRUD.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentResource {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/getAllStudent")
    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    @RequestMapping("/getStudent")
    public Student getStudent(@RequestParam(value="id", defaultValue = "0") String id, @RequestParam(value="name", defaultValue = "Aman") String name){
        try{
            return new Student(Integer.parseInt(id), name);
        }
        catch(Exception e){
            return new Student(0, null);
        }
    }
}
