package com.kolaysoft.proje._yonetimi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long id;
    private String projeAdi;
    private String aciklama;
    private String durum; // yeni, devam ediyor, tamamlandı
}
