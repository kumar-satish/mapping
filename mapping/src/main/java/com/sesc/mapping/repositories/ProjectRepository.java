package com.sesc.mapping.repositories;

import com.sesc.mapping.models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Projects, Integer> {
}
