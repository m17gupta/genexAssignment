package com.genenex.Ass.registerApp.JWTToken;



import com.genenex.Ass.registerApp.domain.Register;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
//    write login in below method to generate jwt token, add user details
    //return token
    @Override
    public Map<String, String> generateToken(Register register) {
        Map<String,String> result=new HashMap<>();

        Map<String,Object> data= new HashMap<>();
        data.put("userObject",register);
        String jwtToken = Jwts.builder()
                .setClaims(data)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"mysecurekey").compact();
        result.put("token",jwtToken);
        result.put("message","User successfully logged in");
        return result;
    }
}
