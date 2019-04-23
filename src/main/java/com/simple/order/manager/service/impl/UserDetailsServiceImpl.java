package com.simple.order.manager.service.impl;

import com.simple.order.manager.model.AppUserPrincipal;
import com.simple.order.manager.pojo.UserPOJO;
import com.simple.order.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserPOJO user = userRepository.findUserPOJOByName(name);
        if(user==null) throw new UsernameNotFoundException("User by username: "+name+" not found");
        return new AppUserPrincipal(user);
    }


}
