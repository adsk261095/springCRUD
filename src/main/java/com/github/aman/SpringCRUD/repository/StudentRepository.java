package com.github.aman.SpringCRUD.repository;

import com.github.aman.SpringCRUD.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository <Student, Integer> {
    @Query(value="select s from Student s where s.name = ?1")
    List<Student> findStudentByName(String name);
}
