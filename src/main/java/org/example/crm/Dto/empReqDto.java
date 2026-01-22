package org.example.crm.Dto;

import lombok.Data;
import org.example.crm.Enum.empStatus;

@Data
public class empReqDto {
    private  String name;
    private int age;
    private String mobileNumber;
    private String email;
    private Double salary;
    private String joiningDate;
    private String designation;
    private empStatus empStatus;
    private  String username;
    private String password;
}
