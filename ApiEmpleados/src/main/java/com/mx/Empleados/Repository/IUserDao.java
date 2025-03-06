package com.mx.Empleados.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Empleados.Entity.User;

public interface IUserDao extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);
}
