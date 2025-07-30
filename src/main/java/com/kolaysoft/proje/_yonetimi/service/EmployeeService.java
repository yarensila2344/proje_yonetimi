//package com.kolaysoft.proje._yonetimi.service;
//
//import com.kolaysoft.proje._yonetimi.dto.EmployeeDto;
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import com.kolaysoft.proje._yonetimi.entity.Role;
//import com.kolaysoft.proje._yonetimi.enums.RoleEnum;
//import com.kolaysoft.proje._yonetimi.repository.EmployeeRepository;
//import com.kolaysoft.proje._yonetimi.repository.RoleRepository;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class EmployeeService {
//
//    private final EmployeeRepository employeeRepository;
//    private final ModelMapper modelMapper;
//    private final RoleRepository roleRepository;
//
//    public EmployeeDto save(EmployeeDto dto) {
//        Employee entity = modelMapper.map(dto, Employee.class);
//
//        Role role = roleRepository.findByName(dto.getRolAdi())
//                .orElseThrow(() -> new RuntimeException("Rol bulunamadı: " + dto.getRolAdi()));
//
//        entity.setRol(role);
//        Employee saved = employeeRepository.save(entity);
//
//        return convertToDto(saved);
//    }
//
//    public List<EmployeeDto> findAll() {
//        return employeeRepository.findAll().stream()
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
//    }
//
//    public EmployeeDto findById(Long id) {
//        return employeeRepository.findById(id)
//                .map(this::convertToDto)
//                .orElse(null);
//    }
//
//    public void delete(Long id) {
//        employeeRepository.deleteById(id);
//    }
//
//    public EmployeeDto update(Long id, EmployeeDto dto) {
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Çalışan bulunamadı: " + id));
//
//        employee.setAd(dto.getAd());
//        employee.setSoyad(dto.getSoyad());
//        employee.setEmail(dto.getEmail());
//        employee.setTelefon(dto.getTelefon());
//        employee.setUsername(dto.getUsername());
//        employee.setPassword(dto.getPassword());
//
//        Role role = roleRepository.findByName(dto.getRolAdi())
//                .orElseThrow(() -> new RuntimeException("Rol bulunamadı: " + dto.getRolAdi()));
//
//        employee.setRol(role);
//        Employee updated = employeeRepository.save(employee);
//
//        return convertToDto(updated);
//    }
//
//    public EmployeeDto partialUpdate(Long id, Map<String, Object> updates) {
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Çalışan bulunamadı: " + id));
//
//        updates.forEach((key, value) -> {
//            switch (key) {
//                case "ad" -> employee.setAd((String) value);
//                case "soyad" -> employee.setSoyad((String) value);
//                case "email" -> employee.setEmail((String) value);
//                case "telefon" -> employee.setTelefon((String) value);
//                case "username" -> employee.setUsername((String) value);
//                case "password" -> employee.setPassword((String) value);
//                case "rolAdi" -> {
//                    try {
//                        RoleEnum roleEnum = RoleEnum.valueOf(((String) value).toUpperCase());
//                        Role role = roleRepository.findByName(roleEnum.name())
//                                .orElseThrow(() -> new RuntimeException("Rol bulunamadı: " + roleEnum.name()));
//                        employee.setRol(role);
//                    } catch (IllegalArgumentException e) {
//                        throw new RuntimeException("Geçersiz rol adı: " + value);
//                    }
//                }
//                default -> throw new IllegalArgumentException("Geçersiz alan: " + key);
//            }
//        });
//
//        Employee updated = employeeRepository.save(employee);
//        return convertToDto(updated);
//    }
//
//    // Yardımcı dönüşüm metodu
//    private EmployeeDto convertToDto(Employee entity) {
//        EmployeeDto dto = modelMapper.map(entity, EmployeeDto.class);
//        dto.setRolAdi(entity.getRol() != null ? entity.getRol().getName() : null);
//        return dto;
//    }
//}

package com.kolaysoft.proje._yonetimi.service;

import com.kolaysoft.proje._yonetimi.dto.EmployeeDto;
import com.kolaysoft.proje._yonetimi.entity.Employee;
import com.kolaysoft.proje._yonetimi.entity.Role;
import com.kolaysoft.proje._yonetimi.enums.RoleEnum;
import com.kolaysoft.proje._yonetimi.mapper.EmployeeMapper;
import com.kolaysoft.proje._yonetimi.repository.EmployeeRepository;
import com.kolaysoft.proje._yonetimi.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository,
                           RoleRepository roleRepository,
                           EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDto save(EmployeeDto dto) {
        Role role = roleRepository.findByName(dto.getRolAdi())
                .orElseThrow(() -> new RuntimeException("Rol bulunamadı: " + dto.getRolAdi()));

        Employee entity = employeeMapper.toEntity(dto, role);
        Employee saved = employeeRepository.save(entity);
        return employeeMapper.toDto(saved);
    }

    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

    public EmployeeDto findById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toDto)
                .orElse(null);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto update(Long id, EmployeeDto dto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Çalışan bulunamadı: " + id));

        employee.setAd(dto.getAd());
        employee.setSoyad(dto.getSoyad());
        employee.setEmail(dto.getEmail());
        employee.setTelefon(dto.getTelefon());
        employee.setUsername(dto.getUsername());
        employee.setPassword(dto.getPassword());

        Role role = roleRepository.findByName(dto.getRolAdi())
                .orElseThrow(() -> new RuntimeException("Rol bulunamadı: " + dto.getRolAdi()));

        employee.setRol(role);

        Employee updated = employeeRepository.save(employee);
        return employeeMapper.toDto(updated);
    }

    public EmployeeDto partialUpdate(Long id, Map<String, Object> updates) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Çalışan bulunamadı: " + id));

        updates.forEach((key, value) -> {
            switch (key) {
                case "ad" -> employee.setAd((String) value);
                case "soyad" -> employee.setSoyad((String) value);
                case "email" -> employee.setEmail((String) value);
                case "telefon" -> employee.setTelefon((String) value);
                case "username" -> employee.setUsername((String) value);
                case "password" -> employee.setPassword((String) value);
                case "rolAdi" -> {
                    try {
                        RoleEnum roleEnum = RoleEnum.valueOf(((String) value).toUpperCase());
                        Role role = roleRepository.findByName(roleEnum.name())
                                .orElseThrow(() -> new RuntimeException("Rol bulunamadı: " + roleEnum.name()));
                        employee.setRol(role);
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException("Geçersiz rol adı: " + value);
                    }
                }
                default -> throw new IllegalArgumentException("Geçersiz alan: " + key);
            }
        });

        Employee updated = employeeRepository.save(employee);
        return employeeMapper.toDto(updated);
    }
}

