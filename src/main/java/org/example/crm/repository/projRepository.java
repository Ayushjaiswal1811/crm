package org.example.crm.repository;

import org.example.crm.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projRepository extends JpaRepository<Project,Long> {
}
