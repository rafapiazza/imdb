package com.example.interview.controllers;

import com.example.interview.models.AuthenticationRequest;
import com.example.interview.models.AuthenticationResponse;
import com.example.interview.models.dtos.UserDTO;
import com.example.interview.services.UserService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@SecurityScheme(name = "bearerTest", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
@RequestMapping("/user")

@AllArgsConstructor

public class UserController {

    private UserService userService;

//    @GetMapping("")
//    public List<UserDTO> getUsers() {
//        return userService.getUsers();
//    }

//    @GetMapping("/{username}")
//    public UserDTO getByUser(@PathVariable String username) {
//        return userService.getUserByUsername(username);
//    }

    @PostMapping("/register")
    public UserDTO createUsers(
            @RequestBody @Valid UserDTO userDto) throws Exception {
        return userService.createUser(userDto);
    }

    @PostMapping("/login")
    public AuthenticationResponse loginUser(
            @RequestBody @Valid AuthenticationRequest user) throws Exception {
        return userService.loginUser(user);
    }

    @PutMapping("update/{username}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String username, @RequestBody UserDTO userDTO) {
        return userService.updateUser(username, userDTO);
    }


    @GetMapping("/username/{username}/listUser")
    public List<UserDTO> getAllNormalUsers(
            @PathVariable String username,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return userService.getNormalUsers(username, page, size);
    }


    @DeleteMapping("/username/{username}")
    public Map<String, String> deleteUser(@PathVariable(value = "username") String username,
                                          @RequestBody String password) {
        return userService.deleteUser(username, password);
    }


}
