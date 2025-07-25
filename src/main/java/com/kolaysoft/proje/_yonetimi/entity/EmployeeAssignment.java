package com.kolaysoft.proje._yonetimi.entity;

import com.kolaysoft.proje._yonetimi.entity.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employee_assignment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private com.kolaysoft.proje._yonetimi.entity.Project project;

    @Column(name = "assignment_date", nullable = false)
    private LocalDate assignmentDate = LocalDate.now();

    @Column(name = "active", nullable = false)
    private boolean active = true;
}