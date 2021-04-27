package com.malu.ecommerce.repository;

import com.malu.ecommerce.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
