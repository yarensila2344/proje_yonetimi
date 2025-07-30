package com.kolaysoft.proje._yonetimi.service;

import com.kolaysoft.proje._yonetimi.dto.EmployeeAssignmentDto;
import com.kolaysoft.proje._yonetimi.entity.EmployeeAssignment;
import com.kolaysoft.proje._yonetimi.repository.EmployeeAssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeAssignmentService {

    private final EmployeeAssignmentRepository assignmentRepository;
    private final ModelMapper modelMapper;

    public EmployeeAssignmentService(EmployeeAssignmentRepository assignmentRepository, ModelMapper modelMapper) {
        this.assignmentRepository = assignmentRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeAssignmentDto save(EmployeeAssignmentDto dto) {
        EmployeeAssignment entity = modelMapper.map(dto, EmployeeAssignment.class);
        entity.setAssignmentDate(LocalDate.now());
        entity.setActive(true);
        return modelMapper.map(assignmentRepository.save(entity), EmployeeAssignmentDto.class);
    }

    public List<EmployeeAssignmentDto> findAll() {
        return assignmentRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, EmployeeAssignmentDto.class))
                .collect(Collectors.toList());
    }

    public List<EmployeeAssignmentDto> findByEmployeeId(Long employeeId) {
        return assignmentRepository.findByEmployeeId(employeeId).stream()
                .map(entity -> modelMapper.map(entity, EmployeeAssignmentDto.class))
                .collect(Collectors.toList());
    }

    public List<EmployeeAssignmentDto> findByProjectId(Long projectId) {
        return assignmentRepository.findByProjectId(projectId).stream()
                .map(entity -> modelMapper.map(entity, EmployeeAssignmentDto.class))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        assignmentRepository.deleteById(id);
    }
}
