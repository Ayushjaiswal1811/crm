package org.example.crm.controller;


import org.example.crm.Dto.deptReqDto;
import org.example.crm.model.Department;
import org.example.crm.model.User;
import org.example.crm.service.deptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class departmentController {
    @Autowired
    private deptService deptService;
    @PostMapping("/admin/departments")
    public ResponseEntity<String> adduser(@RequestBody deptReqDto deptReqDto){
        Department dept = new Department();
        dept.setName(deptReqDto.getName());
        dept.setDescription(deptReqDto.getDescription());
        deptService.createDepartment(dept);
        return ResponseEntity.status(HttpStatus.CREATED).body("Department Created Successfully.");
    }
}
