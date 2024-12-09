package com.example.SpringBootCrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCrud.Beans.User;
import com.example.SpringBootCrud.Service.LoginService;
import com.example.SpringBootCrud.Service.UserService;



@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api/auth")
public class LoginController {
	@Autowired
	LoginService ls;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		User u = ls.RegisterUser(user);
		if(u!=null) {
			return ResponseEntity.ok("Registered successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unable to register");
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user){
		boolean isAuthenticate = ls.loginUser(user.getEmail(), user.getPassword());
		if(isAuthenticate) {
			return ResponseEntity.ok("Logged in successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
		}
	}
	

}
