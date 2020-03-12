package com.github.aman.SpringCRUD.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student  implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    @Column(name="ID")
//    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
//    , generator = "SEQ_GEN")
    private int id;

    @Column(name="Name")
    private String name;

    public Student(){

    }
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
