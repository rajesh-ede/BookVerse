package bookverse.BookService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWtService {
    private static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkeymysecretkey";


    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis()+ 1000 * 60 * 60)
                ).signWith(
                        SignatureAlgorithm.HS256,
                        SECRET_KEY
                )
                .compact();
    }
}
