package com.example.testit.service;

import java.util.ArrayList;

import com.example.testit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserService implements UserDetailsService  {
    private static Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        com.example.testit.model.User res =  repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("L'utilisateur n'existe pas"));

        return  new User(res.getUsername(),res.getPassword(),new ArrayList<>());


    }
}