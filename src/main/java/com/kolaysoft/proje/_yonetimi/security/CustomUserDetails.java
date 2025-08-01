////package com.kolaysoft.proje._yonetimi.security;
////
////import com.kolaysoft.proje._yonetimi.entity.Employee;
////import org.springframework.security.core.GrantedAuthority;
////import org.springframework.security.core.authority.SimpleGrantedAuthority;
////import org.springframework.security.core.userdetails.UserDetails;
////
////import java.util.Collection;
////import java.util.Collections;
////
////public class CustomUserDetails implements UserDetails {
////
////    private final Employee employee;
////
////    public CustomUserDetails(Employee employee) {
////        this.employee = employee;
////    }
////
////    public String getRoleName() {
////        return employee.getRol().getName();  // ✅ BURAYA yazıyoruz
////    }
////
////    @Override
////    public Collection<? extends GrantedAuthority> getAuthorities() {
////        // Çalışanın rolünü alıyoruz, yoksa "USER" atıyoruz
////        String roleName = employee.getRol() != null ? employee.getRol().getId() : "USER";  // ✅ Bu doğru
////
////        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roleName));
////    }
////
////    @Override
////    public String getPassword() {
////        return employee.getPassword();
////    }
////
////    @Override
////    public String getUsername() {
////        return employee.getUsername();
////    }
////
////    @Override
////    public boolean isAccountNonExpired() {
////        return true;  // Eğer hesap süresi dolmadıysa true döner, burada hep true verdik
////    }
////
////    @Override
////    public boolean isAccountNonLocked() {
////        return true;  // Hesap kilitli değil
////    }
////
////    @Override
////    public boolean isCredentialsNonExpired() {
////        return true;  // Şifre süresi dolmadı
////    }
////
////    @Override
////    public boolean isEnabled() {
////        return true;  // Hesap aktif
////    }
////
////    public Employee getEmployee() {
////        return employee;
////    }
////}
//
//package com.kolaysoft.proje._yonetimi.security;
//
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//
//public class CustomUserDetails implements UserDetails {
//
//    private final Employee employee;
//
//    public CustomUserDetails(Employee employee) {
//        this.employee = employee;
//    }
//
//    public String getRoleName() {
//        return employee.getRol() != null ? employee.getRol().getName() : "USER";
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        String roleName = getRoleName();
//        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roleName));
//    }
//
//    @Override
//    public String getPassword() {
//        return employee.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return employee.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public Employee getEmployee() {
//        return employee;
//    }
//}
//
//package com.kolaysoft.proje._yonetimi.security;
//
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//
//public class CustomUserDetails implements UserDetails {
//
//    private final Employee employee;
//
//    public CustomUserDetails(Employee employee) {
//        this.employee = employee;
//    }
//
//    public String getRoleName() {
//        // Burada rol adı için getAd() kullanıyoruz (rol entity'sindeki alan adı)
//        return employee.getRol() != null ? employee.getRol().getAd() : "USER";
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        String roleName = getRoleName();
//        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roleName));
//    }
//
//    @Override
//    public String getPassword() {
//        return employee.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return employee.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;  // Gerekirse gerçek mantık yazılır
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;  // Gerekirse gerçek mantık yazılır
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;  // Gerekirse gerçek mantık yazılır
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;  // Gerekirse gerçek mantık yazılır
//    }
//
//    public Employee getEmployee() {
//        return employee;
//    }
//}

package com.kolaysoft.proje._yonetimi.security;

import com.kolaysoft.proje._yonetimi.entity.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Employee employee;

    public CustomUserDetails(Employee employee) {
        this.employee = employee;
    }

    public String getRoleName() {
        // Role adı entity’de name olarak tanımlı!
        return employee.getRol() != null ? employee.getRol().getName() : "USER";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roleName = getRoleName();
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roleName));
    }

    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // İstersen gerçek durum mantığını ekleyebilirsin
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Employee getEmployee() {
        return employee;
    }
}
