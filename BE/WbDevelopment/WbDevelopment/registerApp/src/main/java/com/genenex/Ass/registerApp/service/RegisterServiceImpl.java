package com.genenex.Ass.registerApp.service;

import com.genenex.Ass.registerApp.Exception.UserAlreadyRegister;
import com.genenex.Ass.registerApp.Exception.UserNotFounds;
import com.genenex.Ass.registerApp.domain.DTOUser;
import com.genenex.Ass.registerApp.domain.Register;
import com.genenex.Ass.registerApp.proxy.EmployeeProxy;
import com.genenex.Ass.registerApp.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private EmployeeProxy employeeProxy;
    @Override
    public Register register(Register register)  throws UserAlreadyRegister {
        DTOUser user1= new DTOUser(register.getName(), register.getEmail(), register.getRole());
        ResponseEntity<?> adduser= employeeProxy.addUserProfile(user1);
        if(registerRepository.findById(register.getEmail()).isPresent()){
             throw new UserAlreadyRegister();
        }else{

            return registerRepository.save(register);
        }


    }

    @Override
    public Register login(String username, String password) throws UserNotFounds {
        if(registerRepository.findById(username).isPresent()){
            Register user=registerRepository.findById(username).get();
            if(user.getPassword().equalsIgnoreCase(password)){
                return user;
            }
            else {
                return null;
            }
        }
        return null;
    }
}
