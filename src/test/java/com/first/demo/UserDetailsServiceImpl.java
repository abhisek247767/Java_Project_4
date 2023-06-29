package com.first.demo;
import com.first.demo.UserDetailsImpl;
import com.first.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.first.demo.user.UserRepository;
//import com.first.demo.user.User;

import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

  @Autowired
  private UserRepository userRepository;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    return new UserDetailsImpl(user);
  }
}
