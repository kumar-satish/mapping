package com.sesc.mapping.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Projects {
    @Id
    private Integer projectId;
    private String projectName;
    private String projectDomain;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_project",
            joinColumns = {
                    @JoinColumn(name = "project_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "student_id")
            }
    )
    private List<Student> students = new ArrayList<>();
}
