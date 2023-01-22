package com.genenex.Ass.MainApp.repository;

import com.genenex.Ass.MainApp.domain.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile,String> {
}
