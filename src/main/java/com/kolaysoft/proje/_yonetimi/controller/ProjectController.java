package com.kolaysoft.proje._yonetimi.controller;

import com.kolaysoft.proje._yonetimi.dto.ProjectDto;
import com.kolaysoft.proje._yonetimi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ProjectDto create(@RequestBody ProjectDto dto) {
        return projectService.save(dto);
    }

    @GetMapping
    public List<ProjectDto> getAll() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public ProjectDto getById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectService.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> update(@PathVariable Long id, @RequestBody ProjectDto projectDto) {
        ProjectDto updatedProject = projectService.update(id, projectDto);
        return ResponseEntity.ok(updatedProject);
    }


}
