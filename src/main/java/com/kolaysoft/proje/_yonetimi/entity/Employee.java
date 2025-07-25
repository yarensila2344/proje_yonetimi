package com.kolaysoft.proje._yonetimi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad", nullable = false)
    private String ad;

    @Column(name = "soyad", nullable = false)
    private String soyad;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "kullanici_adi", nullable = false, unique = true)
    private String username;

    @Column(name = "sifre", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private com.kolaysoft.proje._yonetimi.entity.Role rol;
}