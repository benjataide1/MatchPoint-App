package com.app.matchpoint.repository;

import com.app.matchpoint.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User, Long> {
}
