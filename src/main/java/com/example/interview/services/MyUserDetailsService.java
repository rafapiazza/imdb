//package com.example.interview.services;
//
//import com.example.interview.repositories.UserRepository;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    private UserRepository userRepository;
//
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        com.example.interview.models.entities.User user = userRepository.findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User: " + username + " not found");
//        }
//
//        String[] roles = user.getIsAdmin() ? new String[]{"ADMIN", "USER"} : new String[]{"USER"};
//
//        return User
//                .builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .roles(roles)
//                .build();
//    }
//}
