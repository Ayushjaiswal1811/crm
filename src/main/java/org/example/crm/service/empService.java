package org.example.crm.service;

import org.example.crm.model.Employee;
import org.example.crm.repository.empRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class empService {
    @Autowired
    private empRepository repository;

    public Employee addEmployee(Employee employee){
        if (repository.existsByEmail(employee.getEmail())){
            throw new RuntimeException("User already exists");
        }else {return repository.save(employee);}
    }
    public List<Employee> getAll(){
        return repository.findAll();
    }
}
