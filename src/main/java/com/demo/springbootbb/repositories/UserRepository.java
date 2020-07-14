package com.demo.springbootbb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springbootbb.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	User findByUsername(String username);

}
