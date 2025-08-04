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
//package com.kolaysoft.proje._yonetimi.security;
//
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class JwtService {
//
//    private final String SECRET_KEY = "gizliAnahtar123gizliAnahtar123gizliAnahtar123gizliAnahtar123";
//
//    public String generateToken(Employee user) {
//        return Jwts.builder()
//                .setSubject(user.getUsername())
//                .claim("role", user.getRol() != null ? user.getRol().getName() : "USER")
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 saat geçerli
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public String extractUser(String jwt) {
//    }
//
//    public boolean isTokenValid(String jwt, UserDetails userDetails) {
//        return false;
//    }
//}
//package com.kolaysoft.proje._yonetimi.security;
//
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import io.jsonwebtoken.*;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class JwtService {
//
//    private final String SECRET_KEY = "gizliAnahtar123gizliAnahtar123gizliAnahtar123gizliAnahtar123";
//
//    // ✅ 1. Token oluştur
//    public String generateToken(Employee user) {
//        return Jwts.builder()
//                .setSubject(user.getUsername()) // kullanıcının username’i
//                .claim("role", user.getRol() != null ? user.getRol().getName() : "USER") // rol claim’i
//                .setIssuedAt(new Date()) // oluşturulma zamanı
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 saat geçerli
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // imzalama algoritması
//                .compact();
//    }
//
//    // ✅ 2. Username’i token'dan çıkar
//    public String extractUser(String token) {
//        return extractClaims(token).getSubject();
//    }
//
//    // ✅ 3. Token geçerli mi kontrol et
//    public boolean isTokenValid(String token, UserDetails userDetails) {
//        final String username = extractUser(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//    // ✅ 4. Token süresi dolmuş mu?
//    private boolean isTokenExpired(String token) {
//        return extractClaims(token).getExpiration().before(new Date());
//    }
//
//    // ✅ 5. Token’dan tüm claim’leri al
//    private Claims extractClaims(String token) {
//        try {
//            return Jwts.parser()
//                    .setSigningKey(SECRET_KEY)
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (ExpiredJwtException e) {
//            throw new RuntimeException("Token süresi dolmuş", e);
//        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
//            throw new RuntimeException("Geçersiz JWT token", e);
//        }
//    }
//}
//package com.kolaysoft.proje._yonetimi.security;
//
//import com.kolaysoft.proje._yonetimi.entity.Employee;
//import io.jsonwebtoken.*;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.function.Function;
//
//@Service
//public class JwtService {
//
//    private final String SECRET_KEY = "gizliAnahtar123gizliAnahtar123gizliAnahtar123gizliAnahtar123";
//
//    // Token üretme
//    public String generateToken(Employee user) {
//        return Jwts.builder()
//                .setSubject(user.getUsername())
//                .claim("role", user.getRol() != null ? user.getRol().getName() : "USER")
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)) // 1 saat geçerli
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    // Token'dan kullanıcı adını almaf
//    public String extractUser(String jwt) {
//        return extractClaim(jwt, Claims::getSubject);
//    }
//
//    // Token geçerli mi kontrolü
//    public boolean isTokenValid(String jwt, UserDetails userDetails) {
//        final String username = extractUser(jwt);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
//    }
//
//    // Token'dan expiration tarihi al
//    public Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    // Token expired mi?
//    private boolean isTokenExpired(String token) {
//        try {
//            return extractExpiration(token).before(new Date());
//        } catch (ExpiredJwtException e) {
//            return true;
//        }
//    }
//
//    // Generic claim extraction
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    // Token'dan Claims (veriler) alma
//    public Claims extractClaims(String token) {
//        try {
//            return Jwts.parser()
//                    .setSigningKey(SECRET_KEY)
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (ExpiredJwtException e) {
//            throw new RuntimeException("Token süresi dolmuş");
//        } catch (UnsupportedJwtException e) {
//            throw new RuntimeException("Desteklenmeyen JWT");
//        } catch (MalformedJwtException e) {
//            throw new RuntimeException("Bozuk JWT");
//        } catch (SignatureException e) {
//            throw new RuntimeException("İmza doğrulanamadı");
//        } catch (IllegalArgumentException e) {
//            throw new RuntimeException("Token boş ya da hatalı");
//        }
//    }
//}

package com.kolaysoft.proje._yonetimi.security;

import com.kolaysoft.proje._yonetimi.entity.Employee;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET_KEY = "gizliAnahtar123gizliAnahtar123gizliAnahtar123gizliAnahtar123";

    // Token üretme (örnek: 7 gün geçerli)
    public String generateToken(Employee user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", user.getRol() != null ? user.getRol().getName() : "USER")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7)) // 7 gün
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Token'dan kullanıcı adını alma
    public String extractUser(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    // Token geçerli mi kontrolü
    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        final String username = extractUser(jwt);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
    }

    // Token'dan expiration tarihi alma
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Token süresi dolmuş mu?
    private boolean isTokenExpired(String token) {
        try {
            return extractExpiration(token).before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    // Generic claim extraction
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractClaims(token);
        return claimsResolver.apply(claims);
    }

    // Token'dan Claims alma
    public Claims extractClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("Token süresi dolmuş");
        } catch (UnsupportedJwtException e) {
            throw new RuntimeException("Desteklenmeyen JWT");
        } catch (MalformedJwtException e) {
            throw new RuntimeException("Bozuk JWT");
        } catch (SignatureException e) {
            throw new RuntimeException("İmza doğrulanamadı");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Token boş ya da hatalı");
        }
    }
}


