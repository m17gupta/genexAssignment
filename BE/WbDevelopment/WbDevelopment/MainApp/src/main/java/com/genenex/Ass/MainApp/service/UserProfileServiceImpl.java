package com.genenex.Ass.MainApp.service;

import com.genenex.Ass.MainApp.domain.Product;
import com.genenex.Ass.MainApp.domain.UserProfile;
import com.genenex.Ass.MainApp.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    private UserProfileRepository userProfileRepository;
    @Override
    public UserProfile addUserProfile(UserProfile userProfile) {
        if(userProfileRepository.findById(userProfile.getEmail()).isPresent()){
            return null;
        }
        else{
            UserProfile userProfile1= new UserProfile(userProfile.getEmail(), userProfile.getName(), userProfile.getRole(), new ArrayList<Product>());
            return userProfileRepository.insert(userProfile1);

        }

    }
}
