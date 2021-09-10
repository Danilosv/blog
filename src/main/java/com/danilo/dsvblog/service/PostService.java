package com.danilo.dsvblog.service;

import java.util.List;

import com.danilo.dsvblog.model.Post;

public interface PostService {

	List<Post> findAll();
	Post findById(Long id);
	Post save(Post post);
	
}
