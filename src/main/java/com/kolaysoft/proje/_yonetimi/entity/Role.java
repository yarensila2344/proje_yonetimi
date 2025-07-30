package com.kolaysoft.proje._yonetimi.entity;

import com.kolaysoft.proje._yonetimi.entity.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name; // ADMIN, PROJECT_MANAGER, EMPLOYEE
    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    private Set<Employee> employees;
}