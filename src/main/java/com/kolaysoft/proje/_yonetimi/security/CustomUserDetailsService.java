////package com.kolaysoft.proje._yonetimi.security;
////
////import com.kolaysoft.proje._yonetimi.entity.Employee;
////import com.kolaysoft.proje._yonetimi.repository.EmployeeRepository;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
////import org.springframework.stereotype.Service;
////
////@Service
////public class CustomUserDetailsService implements UserDetailsService {
////
////    private final EmployeeRepository employeeRepository;
////
////    // Constructor injection ile repository alıyoruz
////    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
////        this.employeeRepository = employeeRepository;
////    }
////
////    // Kullanıcıyı username ile veritabanından bulup CustomUserDetails olarak döner
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        Employee employee = employeeRepository.findByUsername(username)
////                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + username));
////
////        if (employee == null) {
////            throw new UsernameNotFoundException("User not found with username: " + username);
////        }
////        return new CustomUserDetails(employee);
////    }
////}
//
//package com.kolaysoft.proje._yonetimi.security;
//
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import com.kolaysoft.proje._yonetimi.repository.EmployeeRepository;
//import com.kolaysoft.proje._yonetimi.security.CustomUserDetails; // <-- BURAYI EKLEDİK
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final EmployeeRepository employeeRepository;
//
//    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Employee employee = employeeRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + username));
//
//        return new CustomUserDetails(employee);
//    }
//}
//package com.kolaysoft.proje._yonetimi.security;
//
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import com.kolaysoft.proje._yonetimi.repository.EmployeeRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final EmployeeRepository employeeRepository;
//
//    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Employee employee = employeeRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + username));
//
//        return new CustomUserDetails(employee);
//    }
//}


package com.kolaysoft.proje._yonetimi.security;

import com.kolaysoft.proje._yonetimi.entity.Employee;
import com.kolaysoft.proje._yonetimi.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + username));
        return new CustomUserDetails(employee);
    }
}
