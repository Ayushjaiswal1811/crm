package org.example.crm.service;

import org.example.crm.model.Employee;
import org.example.crm.model.Project;
import org.example.crm.repository.empRepository;
import org.example.crm.repository.projRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class projService {
    @Autowired
    private projRepository repository;

    @Autowired
    private empRepository emprepository;

    public Project createProject(Project project){
        return repository.save(project);
    }

        public String assignProject(Long projId, Long empId,boolean isManager) {
        Project project= repository.findById(projId).orElseThrow(()->new RuntimeException("Project Not Found"));
        Employee employee=emprepository.findById(empId).orElseThrow(()->new RuntimeException("Employee Not Found"));
            if (employee.getProject().contains(project)) {
                throw new RuntimeException("Employee already assigned to this project");
            }
            employee.getProject().add(project);
//            project.getTeamMembers().add(employee);
            if(isManager){
                project.setManager(employee);
            }
            emprepository.save(employee);
//            repository.save(project);
            return "employee assigned to projects.";
    }

}
