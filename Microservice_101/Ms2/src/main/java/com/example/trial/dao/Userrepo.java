package com.example.trial.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.trial.model.User;

public interface Userrepo extends CrudRepository<User, Integer>{
	User findByuid(int uid);
}
