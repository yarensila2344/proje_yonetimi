//package com.kolaysoft.proje._yonetimi.entity;
//
//import com.kolaysoft.proje._yonetimi.enums.ProjectStatus;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import java.time.LocalDate;
//import java.util.Set;
//
//@Entity
//@Table(name = "project")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Project {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "description", length = 1000)
//    private String description;
//
//    @Column(name = "start_date")
//    private LocalDate startDate;
//
//    @Column(name = "end_date")
//    private LocalDate endDate;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "status", nullable = false)
//    private ProjectStatus status; // Enum olacak
//
//    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<com.kolaysoft.proje._yonetimi.entity.EmployeeAssignment> assignments;
//}
//
package com.kolaysoft.proje._yonetimi.entity;

import com.kolaysoft.proje._yonetimi.enums.ProjectStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProjectStatus status;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<EmployeeAssignment> assignments;
}
