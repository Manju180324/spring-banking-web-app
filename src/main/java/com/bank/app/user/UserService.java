package com.bank.app.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
/*
Lombok generates constructor like:

public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
}
 */

public class UserService {
    private final UserRepository userRepository;
    public User createUser(User user){

        // check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        return userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
