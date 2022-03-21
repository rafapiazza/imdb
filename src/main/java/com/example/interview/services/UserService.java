package com.example.interview.services;

import com.example.interview.models.AuthenticationRequest;
import com.example.interview.models.AuthenticationResponse;
import com.example.interview.models.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    List<UserDTO> getUsers();

    UserDTO createUser(UserDTO userDTO) throws Exception;

    UserDTO getUserByUsername(String username);

    List<UserDTO> getNormalUsers(String username, int page, int size);

    Map<String, String> deleteUser(String username, String password);

    AuthenticationResponse loginUser(AuthenticationRequest authenticationRequest) throws Exception;

    ResponseEntity<UserDTO> updateUser(String username, UserDTO userDTO);

//    AuthenticationResponse loginUser(AuthenticationRequest user) throws Exception;
}