package com.kolaysoft.proje._yonetimi.repository;

import com.kolaysoft.proje._yonetimi.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // Proje durumuna göre listeleme (NEW, IN_PROGRESS, COMPLETED)
    List<Project> findByStatus(String status);
}
