package org.example.crm.Dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.crm.Enum.projStatus;
import org.example.crm.model.Employee;

import java.time.LocalDate;

@Data
public class projReqDto {
    private  String Projname;
    private String description;
    private LocalDate startedAt;
    private LocalDate endDate;
    private projStatus status;
}
