////package com.kolaysoft.proje._yonetimi.security;
////
////import com.kolaysoft.proje._yonetimi.entity.Employee;
////import io.jsonwebtoken.Jwts;
////import io.jsonwebtoken.SignatureAlgorithm;
////import org.springframework.stereotype.Service;
////
////import java.util.Date;
////
////@Service
////public class JwtService {
////
////    private final String SECRET_KEY = "gizliAnahtar123";  // Gerçek projede .env dosyasına koy
////
////    public String generateToken(Employee user) {
////        return Jwts.builder()
////                .setSubject(user.getUsername())
////                .claim("role", user.getRole().getAd())
////                .setIssuedAt(new Date())
////                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 saat
////                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
////                .compact();
////    }
////}
//
//package com.kolaysoft.proje._yonetimi.security;
//
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class JwtService {
//
//    private final String SECRET_KEY = "gizliAnahtar123";  // Gerçek projede .env dosyasına koy
//
//    public String generateToken(Employee user) {
//        return Jwts.builder()
//                .setSubject(user.getUsername())
//                .claim("role", user.getRol() != null ? user.getRol().getName() : "USER")
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 saat
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//}

//package com.kolaysoft.proje._yonetimi.security;
//
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class JwtService {
//
//    private final String SECRET_KEY = "gizliAnahtar123";  // Gerçek projede dışarı taşı
//
//    public String generateToken(Employee user) {
//        return Jwts.builder()
//                .setSubject(user.getUsername())
//                .claim("role", user.getRol() != null ? user.getRol().getAd() : "USER")
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 saat geçerli
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//}
package com.kolaysoft.proje._yonetimi.security;

import com.kolaysoft.proje._yonetimi.entity.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY = "gizliAnahtar123gizliAnahtar123gizliAnahtar123gizliAnahtar123";

    public String generateToken(Employee user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", user.getRol() != null ? user.getRol().getName() : "USER")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 saat geçerli
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
