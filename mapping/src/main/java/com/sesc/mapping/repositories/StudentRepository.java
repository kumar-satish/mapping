package com.sesc.mapping.repositories;

import com.sesc.mapping.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
