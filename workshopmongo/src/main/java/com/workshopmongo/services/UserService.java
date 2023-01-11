package com.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.catalina.startup.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopmongo.domain.User;
import com.workshopmongo.dto.UserDTO;
import com.workshopmongo.repository.UserRepository;
import com.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll(); 
	}
	
	public User findById(String id) {		
		try {
			User user  = userRepository.findById(id).get();
			
			return user;
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
