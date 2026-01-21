package org.example.crm.repository;

import org.example.crm.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface deptRepository extends JpaRepository<Department,Long> {

}
