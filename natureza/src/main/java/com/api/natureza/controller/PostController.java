package com.api.natureza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.natureza.entity.PostEntity;
import com.api.natureza.form.PostForm;
import com.api.natureza.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/findall")
	public ResponseEntity<List<PostEntity>> getAllPosts(){
		
		return ResponseEntity.status(HttpStatus.OK).body(postService.findAllPosts());
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<PostEntity> savePost(@RequestBody PostForm postForm){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(postForm));
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePost(@PathVariable("id") Long id) {
		
		postService.deletePost(id);
		
	}
	
	@PutMapping("/updatelikes/{id}")
	public void updateQuantLikesPost(@PathVariable("id") Long id) {
		
		postService.updatePostQuantLikes(id);
		
	}
	
}
