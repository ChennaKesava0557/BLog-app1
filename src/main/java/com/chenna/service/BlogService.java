package com.chenna.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.chenna.model.Blog;
import com.chenna.repository.BlogRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BlogService {
	private final BlogRepository blogrefo;

	public Blog addBlog(Blog blog) {
		return blogrefo.save(blog);

	}

	public List<Blog> getAllBlogs() {
		return blogrefo.findAll();

	}

	public Optional<Blog> getBlogById(Long id) {
		return blogrefo.findById(id);
	}

	public Blog updateBlog(Long id, Blog updateBlog) throws Exception {
		Optional<Blog> otp = blogrefo.findById(id);
		if (otp.isEmpty()) {
			throw new Exception("Blog not found with ID");
		}
		Blog blog = otp.get();
		blog.setTitle(updateBlog.getTitle());
		blog.setContent(updateBlog.getContent());
		blog.setAuthor(updateBlog.getAuthor());
		return blogrefo.save(blog);

//		 return blogrefo.findById(id).map(blog -> {
//			 
//	            blog.setTitle(updatedBlog.getTitle());
//	            blog.setContent(updatedBlog.getContent());
//	            blog.setAuthor(updatedBlog.getAuthor());
//	            return blogRepository.save(blog);
//	        }).orElseThrow(() -> new RuntimeException("Blog not found with ID: " + id));
	}

	public void deleteBlog(Long id) {
		blogrefo.deleteById(id);
	}

}
