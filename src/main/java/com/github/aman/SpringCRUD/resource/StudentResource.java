package com.github.aman.SpringCRUD.resource;

import com.github.aman.SpringCRUD.model.Student;
import com.github.aman.SpringCRUD.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class StudentResource {

    @Autowired
    private StudentRepository studentRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static int totalReadReq = 0;

    private static void incrementReadCount(){
        totalReadReq++;
    }
    @Scheduled(cron = "0 0 0 * * *")
    private static void reset(){
        totalReadReq=0;
    }
    public static int getTotalReadReq() {
        return totalReadReq;
    }

    @GetMapping("/getAllStudent")
    public Iterable<Student> getAllStudents(){
        incrementReadCount();
        System.out.println(getTotalReadReq());
        return studentRepository.findAll();
    }

    //get request
    @Cacheable(value = "student", key="#id")
    @GetMapping("/getStudent")
    public Optional<Student> getStudent(@RequestParam(value="id", defaultValue = "0") String id){
        incrementReadCount();
        logger.info("Getting student with id: " + id);
        return studentRepository.findById(Integer.parseInt(id));
    }

    //get request
    @GetMapping("/getStudentByName")
    public Iterable<Student> findStudentByName(@RequestParam(value="name", defaultValue = "Aman") String name){
        incrementReadCount();
        logger.info("Getting student with name: " + name);
        return studentRepository.findStudentByName(name);
    }

    //add request
    @CachePut(value="student", key="#result.id")
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        logger.info("Adding student with id: " + student.getId());
        studentRepository.save(student);
        return student;
    }

    //delete request
    @CacheEvict(value = "student", key="#id")
    @DeleteMapping("/deleteStudentById")
    public void deleteStudentByID(@RequestParam(value="id") int id) {
        logger.info("deleting student with id {}", id);
        studentRepository.deleteById(id);
    }
}
