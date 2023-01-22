package com.genenex.Ass.registerApp.proxy;


import com.genenex.Ass.registerApp.domain.DTOUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="userprofile-server",url= "localhost:9999")
public interface EmployeeProxy {
    @PostMapping("/main-user-app/v1/add-user")
    public ResponseEntity<?> addUserProfile(@RequestBody DTOUser dtoUser);
}
