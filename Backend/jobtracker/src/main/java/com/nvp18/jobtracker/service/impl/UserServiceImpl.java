package com.nvp18.jobtracker.service.impl;

import com.nvp18.jobtracker.dao.User;
import com.nvp18.jobtracker.dto.UserDTO;
import com.nvp18.jobtracker.repository.UserRepository;
import com.nvp18.jobtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = User.builder()
                .userName(userDTO.getUserName())
                .email(userDTO.getEmail())
                .password(encoder.encode(userDTO.getPassword()))
                .build();
        User savedUser = userRepository.save(user);
        return UserDTO.builder()
                .email(savedUser.getEmail())
                .userName(savedUser.getUserName())
                .build();
    }
}
