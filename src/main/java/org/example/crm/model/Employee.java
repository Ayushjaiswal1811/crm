package org.example.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.crm.Enum.empStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private  String name;

    private String mobileNumber;

    private String email;

    private Double salary;

    private int age;

    private String joiningDate;

    private String designation;

    @Enumerated(EnumType.STRING)
    private empStatus empStatus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "managerId")
    private Employee manager;

    @OneToMany(mappedBy="manager")
    @JsonIgnore
    private List<Employee> teamMembers;


    @OneToOne
    @JsonIgnore
    @JoinColumn(name="userId")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="deptId")
    private Department department;

    @OneToMany(mappedBy="manager")
    @JsonIgnore
    private List<Project> projectList;

    @ManyToMany
    @JoinTable(
            name = "employee_id",
            joinColumns = @JoinColumn(name = "EmpId"),
            inverseJoinColumns = @JoinColumn(name = "ProjId")
    )
    private Set<Project> project =new HashSet<>();
}
