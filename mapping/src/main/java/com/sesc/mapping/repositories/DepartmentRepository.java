package com.sesc.mapping.repositories;

import com.sesc.mapping.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
