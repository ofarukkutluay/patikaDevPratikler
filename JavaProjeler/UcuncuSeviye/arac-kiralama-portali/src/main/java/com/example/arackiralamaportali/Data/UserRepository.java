package com.example.arackiralamaportali.Data;

import com.example.arackiralamaportali.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}
