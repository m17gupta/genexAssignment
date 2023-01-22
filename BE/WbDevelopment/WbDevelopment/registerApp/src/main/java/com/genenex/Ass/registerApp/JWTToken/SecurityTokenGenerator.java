package com.genenex.Ass.registerApp.JWTToken;

import com.genenex.Ass.registerApp.domain.Register;


import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String, String> generateToken(Register register);
}
