package org.example.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.crm.Enum.projStatus;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProjId;

    private  String Projname;

    private String description;

    private LocalDate startedAt;

    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private projStatus status;

@ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

@ManyToMany(mappedBy = "project")
@JsonIgnore
    private Set<Employee> teamMembers = new HashSet<>();
}
