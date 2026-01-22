package org.example.crm.Dto;

import lombok.Data;
import org.example.crm.Enum.projStatus;

import java.time.LocalDate;

@Data
public class projReqDto {
    private  String projName;
    private String description;
    private LocalDate startedAt;
    private LocalDate endDate;
    private projStatus status;
}
