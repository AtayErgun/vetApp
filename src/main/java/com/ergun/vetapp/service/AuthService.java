package com.ergun.vetapp.service;

import com.ergun.vetapp.entity.User;
import com.ergun.vetapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    // Constructor Injection
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User registerUser(User user) {
        // İleride buraya şifre şifreleme (BCrypt) eklenebilir
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new RuntimeException("Hatalı şifre!");
        }
    }
}