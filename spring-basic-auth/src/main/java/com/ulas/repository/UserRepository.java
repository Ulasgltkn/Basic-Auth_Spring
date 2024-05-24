package com.ulas.repository;

import com.ulas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserNameAndPassword(String username, String password);

    Optional<User> findByUserName(String username);

}