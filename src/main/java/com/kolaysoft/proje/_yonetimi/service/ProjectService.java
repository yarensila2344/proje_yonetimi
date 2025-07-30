package com.kolaysoft.proje._yonetimi.service;

import com.kolaysoft.proje._yonetimi.dto.ProjectDto;
import com.kolaysoft.proje._yonetimi.entity.Project;
import com.kolaysoft.proje._yonetimi.enums.ProjectStatus;
import com.kolaysoft.proje._yonetimi.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectService(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    public ProjectDto save(ProjectDto dto) {
        Project entity = modelMapper.map(dto, Project.class);
        return modelMapper.map(projectRepository.save(entity), ProjectDto.class);
    }

    public List<ProjectDto> findAll() {
        return projectRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, ProjectDto.class))
                .collect(Collectors.toList());
    }

    public ProjectDto findById(Long id) {
        return projectRepository.findById(id)
                .map(entity -> modelMapper.map(entity, ProjectDto.class))
                .orElse(null);
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    // ✅ Yeni eklenen: update fonksiyonu
    public ProjectDto update(Long id, ProjectDto dto) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isEmpty()) {
            throw new RuntimeException("Proje bulunamadı, ID: " + id);
        }

        Project project = optionalProject.get();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStatus(ProjectStatus.valueOf(dto.getStatus())); // Enum çevirimi

        // Eğer DTO'na startDate ve endDate eklediysen bunları da ekle:
        // project.setStartDate(dto.getStartDate());
        // project.setEndDate(dto.getEndDate());

        Project updated = projectRepository.save(project);
        return modelMapper.map(updated, ProjectDto.class);
    }
}
