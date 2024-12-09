package com.example.SpringBootCrud.Service;

import org.springframework.http.ResponseEntity;

import com.example.SpringBootCrud.Beans.User;

public interface LoginService {

	User RegisterUser(User user);

	boolean loginUser(String email, String password);

}
