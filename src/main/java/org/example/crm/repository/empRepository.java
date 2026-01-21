package org.example.crm.repository;


import org.example.crm.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface empRepository extends JpaRepository<Employee,Long> {
 boolean existsByEmail(String email);
}
