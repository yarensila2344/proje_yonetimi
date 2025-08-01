package com.kolaysoft.proje._yonetimi.controller;

import com.kolaysoft.proje._yonetimi.dto.RoleDto;
import com.kolaysoft.proje._yonetimi.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public RoleDto create(@RequestBody RoleDto dto) {
        return roleService.save(dto);
    }

    @GetMapping
    public List<RoleDto> getAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public RoleDto getById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }
}
