package org.example.crm.controller;

import org.example.crm.Dto.empReqDto;
import org.example.crm.Dto.userReqDto;
import org.example.crm.model.Employee;
import org.example.crm.model.User;
import org.example.crm.service.UserService;
import org.example.crm.service.empService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class empController {
    @Autowired
    private empService service;

    @Autowired
    private UserService userService;

    @PostMapping("/admin/employees")
    public Employee addEmployee(@RequestBody empReqDto eDto){
        Employee employee = new Employee();
        employee.setName(eDto.getName());
        employee.setAge(eDto.getAge());
        employee.setMobileNumber(eDto.getMobileNumber());
        employee.setJoiningDate(eDto.getJoiningDate());
        employee.setEmail(eDto.getEmail());
        employee.setDesignation(eDto.getDesignation());
        employee.setSalary(eDto.getSalary());
        employee.setEmpStatus(eDto.getEmpStatus());
        userReqDto user = new userReqDto();

        user.setUsername(eDto.getUsername());
        user.setPassword(eDto.getPassword());
        service.addEmployee(employee);
        userService.adduser(user);
        User user1 = new User();
        user1.setUsername(eDto.getUsername());
        user1.setPassword(eDto.getPassword());
        employee.setUser(user1);
        return employee;
    }

    @GetMapping("/admin/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        try{
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
