package com.danilo.dsvblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danilo.dsvblog.model.Post;
import com.danilo.dsvblog.repository.PostRepository;
import com.danilo.dsvblog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		return postRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	
}
