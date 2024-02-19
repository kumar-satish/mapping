package com.sesc.mapping.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    private Integer studentId;
    private String studentName;
    private String studentCourse;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToMany(mappedBy = "students")
    private List<Projects> projects = new ArrayList<>();
}
