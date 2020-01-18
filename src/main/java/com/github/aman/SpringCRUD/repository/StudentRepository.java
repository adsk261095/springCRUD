package com.github.aman.SpringCRUD.repository;

import com.github.aman.SpringCRUD.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository <Student, Integer> {
}
