package org.example.crm.controller;

import org.example.crm.Dto.projReqDto;
import org.example.crm.model.Project;
import org.example.crm.service.projService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class projController {
    @Autowired
    private projService service;

    @PostMapping("/")
    public ResponseEntity<Project> createProject(@RequestBody projReqDto Dto) {
        Project project = new Project();
        project.setProjName(Dto.getProjName());
        project.setDescription(Dto.getDescription());
        project.setStartedAt(Dto.getStartedAt());
        project.setStatus(Dto.getStatus());
        project.setEndDate(Dto.getEndDate());

        try {
        return new ResponseEntity<>(service.createProject(project),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/assign{projId}/{empId}")
    public  ResponseEntity<String> assignProject(@PathVariable Long projId, @PathVariable Long empId,@RequestParam(defaultValue = "false") boolean isManager) {
        try {
            return new ResponseEntity<>(service.assignProject(projId,empId,isManager),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
