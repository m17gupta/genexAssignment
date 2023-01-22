package com.genenex.Ass.registerApp.repository;

import com.genenex.Ass.registerApp.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,String> {
}
