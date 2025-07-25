package com.kolaysoft.proje._yonetimi.service;

import com.kolaysoft.proje._yonetimi.dto.ProjectDto;
import com.kolaysoft.proje._yonetimi.entity.Project;
import com.kolaysoft.proje._yonetimi.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
