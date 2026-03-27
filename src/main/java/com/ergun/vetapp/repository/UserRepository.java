package com.ergun.vetapp.repository;

import com.ergun.vetapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Kullanıcı adına göre kullanıcıyı bulmak için
    Optional<User> findByUsername(String username);
}
