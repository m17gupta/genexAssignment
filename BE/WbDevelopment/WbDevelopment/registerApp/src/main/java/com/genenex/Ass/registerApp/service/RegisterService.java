package com.genenex.Ass.registerApp.service;

import com.genenex.Ass.registerApp.Exception.UserAlreadyRegister;
import com.genenex.Ass.registerApp.Exception.UserNotFounds;
import com.genenex.Ass.registerApp.domain.Register;

public interface RegisterService {

    public abstract Register register(Register register) throws UserAlreadyRegister;

    public  abstract Register login(String username, String password) throws UserNotFounds;
}
