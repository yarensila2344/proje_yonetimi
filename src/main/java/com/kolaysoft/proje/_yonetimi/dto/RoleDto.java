package com.kolaysoft.proje._yonetimi.dto;


public class RoleDto {
    private Long id;
    private String ad; // Örn: "Yönetici", "Çalışan"

    public RoleDto(Long id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
