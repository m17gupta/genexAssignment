package com.genenex.Ass.registerApp.controller;

import com.genenex.Ass.registerApp.Exception.UserAlreadyRegister;
import com.genenex.Ass.registerApp.Exception.UserNotFounds;
import com.genenex.Ass.registerApp.JWTToken.SecurityTokenGenerator;
import com.genenex.Ass.registerApp.domain.Register;
import com.genenex.Ass.registerApp.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/genex-app/v1")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;
   // http://localhost:8880/genex-app/v1/register
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Register register) throws UserAlreadyRegister{
        try{
            return  new ResponseEntity<>(registerService.register(register),HttpStatus.OK);
        } catch ( UserAlreadyRegister ex){
         throw new UserAlreadyRegister();
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody Register register) throws UserNotFounds{
        try {
          Register userDetail= registerService.login(register.getEmail(), register.getPassword());
            if (userDetail != null) { //authencation success
//            return new ResponseEntity<>(result,HttpStatus.Ok);
//            get jwt from jwtservice method by passing result oject
                Map<String, String> Key = securityTokenGenerator.generateToken(userDetail);
                return new ResponseEntity<>(Key, HttpStatus.OK);
            } else { //if authenication fails
                return new ResponseEntity<>("Authenication fails", HttpStatus.NOT_FOUND);


            }


        } catch (UserNotFounds ex){
            throw new UserNotFounds();
        }
    }
}
