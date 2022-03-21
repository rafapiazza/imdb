package com.example.interview.services;

import com.example.interview.models.AuthenticationRequest;
import com.example.interview.models.AuthenticationResponse;
import com.example.interview.models.dtos.UserDTO;
import com.example.interview.models.entities.User;
import com.example.interview.repositories.UserRepository;
import com.example.interview.utils.JwtService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
//@RequiredArgsConstructor
public class UserServiceImp implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public List<UserDTO> getUsers() {
//        return Collections.singletonList(new MovieDTO(1L,"Interstellar"));
        List<User> users = userRepository.findAll();

        return new ModelMapper().map(users, new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    @Transactional
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setIsActive(Boolean.TRUE);
        user.setIsAdmin(userDTO.getIsAdmin());
        user.setPassword(encoder.encode(userDTO.getPassword()));

        user = userRepository.save(user);
        return new ModelMapper().map(user, UserDTO.class);
//        return login(user.getUsername(), user.getPassword());
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        return new ModelMapper().map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getNormalUsers(String username, int page, int size) {

        Pageable pageable = Pageable.ofSize(size).withPage(page);

        User user = userRepository.findByUsername(username);
        List<User> users = null;
        if (user.getIsAdmin()) {
            if (!user.getIsActive()) {
                throw new UsernameNotFoundException("User " + username + " is not active!");
            }
            users = userRepository.findAllNormalUser(pageable);

//            users = userRepository.findAllByIsAdmin(false,pageRequest);

            return new ModelMapper().map(users, new TypeToken<List<UserDTO>>() {
            }.getType());
        }
        throw new UsernameNotFoundException("username " + username + " is not admin");
    }

    @Override
    public Map<String, String> deleteUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        Map<String, String> response = new HashMap<>();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (user != null && encoder.matches(password, user.getPassword())) {
//            userRepository.delete(user);
            user.setIsActive(Boolean.FALSE);
            String usernameInactive = userRepository.save(user).getUsername();
            userRepository.updateUserActive(usernameInactive);
            response.put("Deleted user: ", username);
        }
        return response;
    }

    @Override
    public AuthenticationResponse loginUser(AuthenticationRequest authenticationRequest) {
        User user = userRepository.findByUsername(authenticationRequest.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException("User: " + authenticationRequest.getUsername() + " not found");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (encoder.matches(authenticationRequest.getPassword(), user.getPassword())) {
            return new AuthenticationResponse(jwtService.generateToken(user));
        }
        throw new UsernameNotFoundException("Credentials not found");
    }

    public ResponseEntity<UserDTO> updateUser(String username, UserDTO userDTO) {
        User user = userRepository.findByUsername(username);

        if (!username.equals(userDTO.getUsername())) {
            throw new UsernameNotFoundException("username different!");
        }
        user.setUsername(username);
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setIsAdmin(userDTO.getIsAdmin());

        user = userRepository.save(user);

        return ResponseEntity.ok(new ModelMapper().map(user, UserDTO.class));

    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.example.interview.models.entities.User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User: " + username + " not found");
        }

        String[] roles = user.getIsAdmin() ? new String[]{"ADMIN", "USER"} : new String[]{"USER"};

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(roles)
                .build();
    }
}
