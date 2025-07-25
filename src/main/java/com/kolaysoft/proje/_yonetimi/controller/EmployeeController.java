package com.kolaysoft.proje._yonetimi.controller;

import com.kolaysoft.proje._yonetimi.dto.EmployeeDto;
import com.kolaysoft.proje._yonetimi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeDto create(@RequestBody EmployeeDto dto) {
        return employeeService.save(dto);
    }

    @GetMapping
    public List<EmployeeDto> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
