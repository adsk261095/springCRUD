package com.github.aman.SpringCRUD.service;

import com.github.aman.SpringCRUD.model.Student;
import com.github.aman.SpringCRUD.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @PostConstruct
    @Scheduled(cron = "0 */2 * * * *")
    /*
    job scheduled after every 2 minutes
     */
    public void Db_reader(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("querying DB at: " + formatter.format(date));
        Iterable t = studentRepository.findAll();
        t.forEach(x-> System.out.println(x));

    }
}
