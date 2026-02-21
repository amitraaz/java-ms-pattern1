package com.tutorial.servicea.repository;

import com.tutorial.servicea.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
