package com.kolaysoft.proje._yonetimi.repository;

import com.kolaysoft.proje._yonetimi.entity.EmployeeAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeAssignmentRepository extends JpaRepository<EmployeeAssignment, Long> {

    // Bir çalışanın tüm atamaları
    List<EmployeeAssignment> findByEmployeeId(Long employeeId);

    // Bir projenin tüm atamaları
    List<EmployeeAssignment> findByProjectId(Long projectId);
}
