package com.genenex.Ass.MainApp.Controller;

import com.genenex.Ass.MainApp.domain.UserProfile;
import com.genenex.Ass.MainApp.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main-user-app/v1")
public class UserController {

    @Autowired
    private UserProfileService userProfileService;
    //@PostMapping("/main-user-app/v1/add-user")

    @PostMapping("/add-user")
    public ResponseEntity<?> addUserProfile(@RequestBody UserProfile userProfile){
        return new ResponseEntity<>(userProfileService.addUserProfile(userProfile), HttpStatus.OK);
    }
}
