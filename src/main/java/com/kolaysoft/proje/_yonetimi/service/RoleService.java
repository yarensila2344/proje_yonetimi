package com.kolaysoft.proje._yonetimi.service;

import com.kolaysoft.proje._yonetimi.dto.RoleDto;
import com.kolaysoft.proje._yonetimi.entity.Role;
import com.kolaysoft.proje._yonetimi.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    public RoleDto save(RoleDto dto) {
        Role role = modelMapper.map(dto, Role.class);
        return modelMapper.map(roleRepository.save(role), RoleDto.class);
    }

    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream()
                .map(role -> modelMapper.map(role, RoleDto.class))
                .collect(Collectors.toList());
    }

    public RoleDto findById(Long id) {
        return roleRepository.findById(id)
                .map(role -> modelMapper.map(role, RoleDto.class))
                .orElse(null);
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
