////package com.kolaysoft.proje._yonetimi.controller;
////
////import com.kolaysoft.proje._yonetimi.dto.EmployeeDto;
////import com.kolaysoft.proje._yonetimi.service.EmployeeService;
////import lombok.RequiredArgsConstructor;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////import java.util.Map;
////
////@RestController
////@RequestMapping("/api/employees")
////public class EmployeeController {
////
////    private final EmployeeService employeeService;
////
////    public EmployeeController(EmployeeService employeeService) {
////        this.employeeService = employeeService;
////    }
////
////    @PostMapping("/save")
////    public EmployeeDto create(@RequestBody EmployeeDto dto) {
////        return employeeService.save(dto);
////    }
////    @PutMapping("/update/{id}")
////    public EmployeeDto update(@PathVariable Long id, @RequestBody EmployeeDto dto) {
////        return employeeService.update(id, dto);
////    }
////    @GetMapping
////    public List<EmployeeDto> getAll() {
////        return employeeService.findAll();
////    }
////
////    @GetMapping("/{id}")
////    public EmployeeDto getById(@PathVariable Long id) {
////        return employeeService.findById(id);
////    }
////
////    @DeleteMapping("/{id}")
////    public void delete(@PathVariable Long id) {
////        employeeService.delete(id);
////    }
////
////    @PatchMapping("/{id}")
////    public EmployeeDto partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
////        return employeeService.partialUpdate(id, updates);
////    }
////
////
////}
//package com.kolaysoft.proje._yonetimi.controller;
//
//import com.kolaysoft.proje._yonetimi.dto.EmployeeDto;
//import com.kolaysoft.proje._yonetimi.service.EmployeeService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/employees")
//public class EmployeeController {
//
//    private final EmployeeService employeeService;
//
//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//    @PostMapping("/save")
//    public EmployeeDto create(@RequestBody EmployeeDto dto) {
//        return employeeService.save(dto);
//    }
//
//    @PutMapping("/update/{id}")
//    public EmployeeDto update(@PathVariable Long id, @RequestBody EmployeeDto dto) {
//        return employeeService.update(id, dto);
//    }
//
//    @GetMapping
//    public List<EmployeeDto> getAll() {
//        return employeeService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public EmployeeDto getById(@PathVariable Long id) {
//        return employeeService.findById(id)
//                .orElseThrow(() -> new RuntimeException("Çalışan bulunamadı: " + id));
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        employeeService.delete(id);
//    }
//
//    @PatchMapping("/{id}")
//    public EmployeeDto partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
//        return employeeService.partialUpdate(id, updates);
//    }
//}

package com.kolaysoft.proje._yonetimi.controller;

import com.kolaysoft.proje._yonetimi.dto.EmployeeDto;
import com.kolaysoft.proje._yonetimi.service.EmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public EmployeeDto create(@RequestBody EmployeeDto dto) {
        return employeeService.save(dto);
    }

    @PutMapping("/update/{id}")
    public EmployeeDto update(@PathVariable Long id, @RequestBody EmployeeDto dto) {
        return employeeService.update(id, dto);
    }

    @GetMapping("/getAll")
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

    @PatchMapping("/{id}")
    public EmployeeDto partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return employeeService.partialUpdate(id, updates);
    }
}