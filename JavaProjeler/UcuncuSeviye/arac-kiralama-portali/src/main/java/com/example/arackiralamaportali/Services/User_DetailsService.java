package com.example.arackiralamaportali.Services;

import com.example.arackiralamaportali.Data.UserRepository;
import com.example.arackiralamaportali.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class User_DetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public User_DetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        User_Details userDetails=null;
        if (user!=null) {
            userDetails=new User_Details();
            userDetails.setUser(user);
        }else {
            throw new UsernameNotFoundException("User not exist with this name : "+username);
        }
        return userDetails;
    }
}
