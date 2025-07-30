//package com.kolaysoft.proje._yonetimi.mapper;
//
//import com.kolaysoft.proje._yonetimi.dto.EmployeeDto;
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import com.kolaysoft.proje._yonetimi.entity.Role;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmployeeMapper {
//    // Entity -> DTO
//    public EmployeeDto toDto(Employee employee) {
//        EmployeeDto dto = new EmployeeDto();
//        dto.setId(employee.getId());
//        dto.setAd(employee.getAd());
//        dto.setSoyad(employee.getSoyad());
//        dto.setEmail(employee.getEmail());
//        dto.setTelefon(employee.getTelefon());
//        dto.setUsername(employee.getUsername());
//        dto.setPassword(employee.getPassword());
//
//        if (employee.getRol() != null) {
//            dto.setRolAdi(employee.getRol().getName());
//        }
//
//        return dto;
//    }
//
//    // DTO -> Entity (Role objesi dışarıdan verilir)
//    public Employee toEntity(EmployeeDto dto, Role role) {
//        Employee employee = new Employee();
//        employee.setId(dto.getId());
//        employee.setAd(dto.getAd());
//        employee.setSoyad(dto.getSoyad());
//        employee.setEmail(dto.getEmail());
//        employee.setTelefon(dto.getTelefon());
//        employee.setUsername(dto.getUsername());
//        employee.setPassword(dto.getPassword());
//        employee.setRol(role);
//
//        return employee;
//    }
//}
package com.kolaysoft.proje._yonetimi.mapper;

import com.kolaysoft.proje._yonetimi.dto.EmployeeDto;
import com.kolaysoft.proje._yonetimi.entity.Employee;
import com.kolaysoft.proje._yonetimi.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    @Autowired
    private ModelMapper modelMapper;

    // 🔁 ENTITY → DTO (manuel müdahale gerekli çünkü rol ilişkisi var)
    public EmployeeDto toDto(Employee employee) {
        EmployeeDto dto = modelMapper.map(employee, EmployeeDto.class);

        // Eğer rol null değilse, dto'ya manuel olarak rol adını set et
        if (employee.getRol() != null) {
            dto.setRolAdi(employee.getRol().getName());
        }

        return dto;
    }

    // 🔁 DTO → ENTITY (Role dışarıdan verilir çünkü sadece adı geliyor)
    public Employee toEntity(EmployeeDto dto, Role role) {
        Employee employee = modelMapper.map(dto, Employee.class);
        employee.setRol(role); // manuel olarak rol set edilir

        return employee;
    }
}
