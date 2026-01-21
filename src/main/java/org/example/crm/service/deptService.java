package org.example.crm.service;

import org.example.crm.model.Department;
import org.example.crm.model.User;
import org.example.crm.repository.deptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class deptService {
@Autowired
    private deptRepository deptRepository;
    public Department createDepartment(Department dept){
        return deptRepository.save(dept);
    }
}
