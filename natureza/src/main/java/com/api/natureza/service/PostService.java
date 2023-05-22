package com.api.natureza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.natureza.entity.ParqueEntity;
import com.api.natureza.entity.PostEntity;
import com.api.natureza.entity.UsuarioEntity;
import com.api.natureza.form.PostForm;
import com.api.natureza.repository.ParqueRepository;
import com.api.natureza.repository.PostRepository;
import com.api.natureza.repository.UsuarioRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ParqueRepository parqueRepository;
	
	public List<PostEntity> findAllPosts(){
		
		return postRepository.findAll();
		
	}
	
	public PostEntity savePost(PostForm postForm) {
		
		Optional<UsuarioEntity> usuarioFound = usuarioRepository.findById(postForm.getIdUsuario());
		UsuarioEntity usuario = null;
		
		if(usuarioFound.isPresent()) {
			usuario = usuarioFound.get();
		}
		
		Optional<ParqueEntity> parqueFound = parqueRepository.findById(postForm.getIdParque());
		ParqueEntity parque = null;
		
		if(parqueFound.isPresent()) {
			parque = parqueFound.get();
		}
		
		PostEntity post = new PostEntity();
		post.setDescricao(postForm.getDescricao());
		post.setQuantLikes(0L);
		post.setImgName(postForm.getImgName());
		post.setUsuario(usuario);
		post.setParque(parque);
		
		return postRepository.save(post);
		
	}
	
	public void deletePost(Long id) {
		
		postRepository.deleteById(id);
		
	}
	
	public void updatePostQuantLikes(Long id) {
		
		Optional<PostEntity> postFound = postRepository.findById(id);
		PostEntity post = null;
		
		if(postFound.isPresent()) {
			post = postFound.get();
		}
		
		Long quantLikes = post.getQuantLikes();
		
		post.setQuantLikes(quantLikes + 1);
		
		postRepository.save(post);
		
	}
	
}
