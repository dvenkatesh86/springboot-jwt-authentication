package com.example.security.repo;

import com.example.security.model.Users;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{

    Users findByUsername(String username);


}

