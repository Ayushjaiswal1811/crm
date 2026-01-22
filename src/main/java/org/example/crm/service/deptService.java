package org.example.crm.service;

import org.example.crm.model.Department;
import org.example.crm.model.Employee;
import org.example.crm.repository.deptRepository;
import org.example.crm.repository.empRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class deptService {
@Autowired
    private deptRepository deptRepository;

@Autowired
private empRepository empRepository;

    public Department createDepartment(Department dept){
        return deptRepository.save(dept);
    }

    public String assignDept(Long deptId, Long empId) {
        Department department = deptRepository.findById(deptId).orElseThrow(()->new RuntimeException("Department not Found."));
        Employee employee = empRepository.findById(empId).orElseThrow(()->new RuntimeException("Employee Not found."));

        department.getEmployees().add(employee);
        employee.setDepartment(department);
        empRepository.save(employee);
        deptRepository.save(department);
        return "department Assigned Successfully.";
    }
}
