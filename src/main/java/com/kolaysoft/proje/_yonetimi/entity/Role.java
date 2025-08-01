//package com.kolaysoft.proje._yonetimi.entity;
//
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import java.util.Set;
//
//@Entity
//@Table(name = "role")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name", nullable = false, unique = true)
//    private String name;
//    // ADMIN, PROJECT_MANAGER, EMPLOYEE
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
//    private Set<Employee> employees;
//}
//
//package com.kolaysoft.proje._yonetimi.entity;
//
//import jakarta.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "role")
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name", nullable = false, unique = true)
//    private String name;  // ADMIN, PROJECT_MANAGER, EMPLOYEE
//
//    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
//    private Set<Employee> employees;
//
//    // Getter ve Setter
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }
//}
package com.kolaysoft.proje._yonetimi.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // DB sütunu adı 'name', Java alan adı da 'name' olmalı ki getter/setter ve erişim kolay olsun
    @Column(name = "name", nullable = false, unique = true)
    private String name;  // Örnek: ADMIN, PROJECT_MANAGER, EMPLOYEE

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    // Getter ve Setter metodları

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}

