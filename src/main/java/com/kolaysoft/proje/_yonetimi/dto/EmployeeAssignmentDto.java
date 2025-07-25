package com.kolaysoft.proje._yonetimi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAssignmentDto {
    private Long id;
    private Long employeeId;
    private Long projectId;
}
