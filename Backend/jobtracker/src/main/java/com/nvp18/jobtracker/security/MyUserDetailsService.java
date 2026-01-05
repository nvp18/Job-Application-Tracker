package com.nvp18.jobtracker.security;

import com.nvp18.jobtracker.dao.User;
import com.nvp18.jobtracker.dao.UserPrinciple;
import com.nvp18.jobtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrinciple(user.get());
    }
}
