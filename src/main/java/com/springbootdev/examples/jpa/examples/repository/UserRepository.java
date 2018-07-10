package com.springbootdev.examples.jpa.examples.repository;

import com.springbootdev.examples.jpa.examples.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
