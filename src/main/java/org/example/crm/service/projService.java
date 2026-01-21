package org.example.crm.service;

import org.example.crm.Dto.projReqDto;
import org.example.crm.model.Project;
import org.example.crm.repository.projRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class projService {
    @Autowired
    private projRepository repository;

    public Project createProject(Project project){
        return repository.save(project);
    }
}
