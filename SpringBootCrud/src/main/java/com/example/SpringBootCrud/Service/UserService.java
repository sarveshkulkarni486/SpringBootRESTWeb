package com.example.SpringBootCrud.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringBootCrud.Beans.User;
import com.example.SpringBootCrud.Repository.UserRepository;

@Service
public class UserService implements LoginService {
	@Autowired
	private UserRepository userreop;
	private final BCryptPasswordEncoder passwordencoder = new BCryptPasswordEncoder();
	
	
	public User RegisterUser(User user) {
		user.setPassword(passwordencoder.encode(user.getPassword()));
		return userreop.save(user);
	}
	@Override
    public boolean loginUser(String email, String password) {
        Optional<User> userOptional = userreop.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return passwordencoder.matches(password, user.getPassword());
        }
        return false;
    }
}
