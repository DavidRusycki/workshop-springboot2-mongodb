package com.workshopmongo.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopmongo.domain.Post;
import com.workshopmongo.domain.User;
import com.workshopmongo.repository.PostRepository;
import com.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {		
		try {
			Post post  = postRepository.findById(id).get();
			
			return post;
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
	}
		
}
