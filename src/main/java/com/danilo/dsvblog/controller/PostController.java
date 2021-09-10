package com.danilo.dsvblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.danilo.dsvblog.model.Post;
import com.danilo.dsvblog.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mav = new ModelAndView("posts");
		List<Post> posts = postService.findAll();
		mav.addObject("posts", posts);
		return mav;
	}
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("postDetails");
		Post post = postService.findById(id);
		mav.addObject("post", post);
		return mav;
	}

	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public ModelAndView getPostForm() {
		ModelAndView mav = new ModelAndView("postForm");
		return mav;
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String save(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			StringBuilder mens = new StringBuilder();
			for (FieldError e: result.getFieldErrors()) {
				mens.append(e.getField() + " - "+e.getDefaultMessage()+"; ");
				System.out.println(e.getField());
				System.out.println(e.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", mens.toString());
			
			return "redirect:/post/newpost"; 
		}
		
		post.setData(LocalDate.now());
		postService.save(post);
		
		return "redirect:/post/posts";
		
	}
	
	
}
