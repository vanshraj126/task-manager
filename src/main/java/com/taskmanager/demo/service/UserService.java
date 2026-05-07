package com.taskmanager.demo.service;

import com.taskmanager.demo.entity.User;
import com.taskmanager.demo.repository.UserRepository;
import com.taskmanager.demo.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public User registerUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id" + id));

    }

    public String login(String email, String password){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not Found"));

        if (!user.getPassword().equals(password)){
            throw new RuntimeException("Wrong Password");
        }
        return jwtUtil.generateToken(email, user.getRole().name());
    }


}
