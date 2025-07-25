package com.kolaysoft.proje._yonetimi.service;

import com.kolaysoft.proje._yonetimi.dto.EmployeeDto;
import com.kolaysoft.proje._yonetimi.entity.Employee;
import com.kolaysoft.proje._yonetimi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDto save(EmployeeDto dto) {
        Employee entity = modelMapper.map(dto, Employee.class);
        return modelMapper.map(employeeRepository.save(entity), EmployeeDto.class);
    }

    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto findById(Long id) {
        return employeeRepository.findById(id)
                .map(entity -> modelMapper.map(entity, EmployeeDto.class))
                .orElse(null);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
