package com.kolaysoft.proje._yonetimi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String ad;
    private String soyad;
    private String email;
    private String telefon;
    private String username;
    private String password;
    private String rolAdi;  // Role entity'sindeki ad alanı
}
