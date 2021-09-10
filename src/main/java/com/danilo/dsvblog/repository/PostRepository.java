package com.danilo.dsvblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danilo.dsvblog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	
}
