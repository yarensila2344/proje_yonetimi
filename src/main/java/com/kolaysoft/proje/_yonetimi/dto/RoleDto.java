package com.kolaysoft.proje._yonetimi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Long id;
    private String ad; // Örn: "Yönetici", "Çalışan"
}
