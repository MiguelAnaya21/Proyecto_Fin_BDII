/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.fidelizacion.service;

import com.dosideas.fidelizacion.domain.Role;
import com.dosideas.fidelizacion.domain.User;
import com.dosideas.fidelizacion.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author alopezorozco
 */
@Service
public class UserDetailServicempl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
        if ( user == null){
            throw new UsernameNotFoundException("User not found");
        }
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        for(Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));           
        }
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
    
}