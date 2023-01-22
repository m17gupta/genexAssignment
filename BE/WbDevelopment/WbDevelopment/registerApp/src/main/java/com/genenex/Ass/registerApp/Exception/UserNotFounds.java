package com.genenex.Ass.registerApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "User not found")
public class UserNotFounds extends Exception{
}
