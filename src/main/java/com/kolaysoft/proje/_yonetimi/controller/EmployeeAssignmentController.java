package com.kolaysoft.proje._yonetimi.controller;

import com.kolaysoft.proje._yonetimi.dto.EmployeeAssignmentDto;
import com.kolaysoft.proje._yonetimi.service.EmployeeAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class EmployeeAssignmentController {

    private final EmployeeAssignmentService assignmentService;

    public EmployeeAssignmentController(EmployeeAssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public EmployeeAssignmentDto assign(@RequestBody EmployeeAssignmentDto dto) {
        return assignmentService.save(dto);
    }

    @GetMapping
    public List<EmployeeAssignmentDto> getAll() {
        return assignmentService.findAll();
    }

    @GetMapping("/by-employee/{employeeId}")
    public List<EmployeeAssignmentDto> getByEmployee(@PathVariable Long employeeId) {
        return assignmentService.findByEmployeeId(employeeId);
    }

    @GetMapping("/by-project/{projectId}")
    public List<EmployeeAssignmentDto> getByProject(@PathVariable Long projectId) {
        return assignmentService.findByProjectId(projectId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        assignmentService.delete(id);
    }
}


//import com.kolaysoft.proje._yonetimi.dto.EmployeeAssignmentDto;
//import com.kolaysoft.proje._yonetimi.service.EmployeeAssignmentService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/assignments")
//public class EmployeeAssignmentController {
//
//    private final EmployeeAssignmentService assignmentService;
//
//    public EmployeeAssignmentController(EmployeeAssignmentService assignmentService) {
//        this.assignmentService = assignmentService;
//    }
//
//    @PostMapping
//    public EmployeeAssignmentDto assign(@RequestBody EmployeeAssignmentDto dto) {
//        return assignmentService.save(dto);
//    }
//
//    @GetMapping
//    public List<EmployeeAssignmentDto> getAll() {
//        return assignmentService.findAll();
//    }
//
//    @GetMapping("/by-employee/{employeeId}")
//    public List<EmployeeAssignmentDto> getByEmployee(@PathVariable Long employeeId) {
//        return assignmentService.findByEmployeeId(employeeId);
//    }
//
//    @GetMapping("/by-project/{projectId}")
//    public List<EmployeeAssignmentDto> getByProject(@PathVariable Long projectId) {
//        return assignmentService.findByProjectId(projectId);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        assignmentService.delete(id);
//    }
//}


//import com.kolaysoft.proje._yonetimi.dto.EmployeeAssignmentDto;
//import com.kolaysoft.proje._yonetimi.service.EmployeeAssignmentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/assignments")
//@RequiredArgsConstructor
//public class EmployeeAssignmentController {
//
//    private final EmployeeAssignmentService assignmentService;
//
//    @PostMapping
//    public EmployeeAssignmentDto assign(@RequestBody EmployeeAssignmentDto dto) {
//        return assignmentService.save(dto);
//    }
//
//    @GetMapping
//    public List<EmployeeAssignmentDto> getAll() {
//        return assignmentService.findAll();
//    }
//
//    @GetMapping("/by-employee/{employeeId}")
//    public List<EmployeeAssignmentDto> getByEmployee(@PathVariable Long employeeId) {
//        return assignmentService.findByEmployeeId(employeeId);
//    }
//
//    @GetMapping("/by-project/{projectId}")
//    public List<EmployeeAssignmentDto> getByProject(@PathVariable Long projectId) {
//        return assignmentService.findByProjectId(projectId);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        assignmentService.delete(id);
//    }
//}


