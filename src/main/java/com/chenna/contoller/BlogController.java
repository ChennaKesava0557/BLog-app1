package com.chenna.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chenna.model.Blog;
import com.chenna.service.BlogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor
public class BlogController 
{
   public final BlogService blogservice;
   
   @PostMapping
   public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
       return ResponseEntity.ok(blogservice.addBlog(blog));
   }
   @GetMapping
   public ResponseEntity<List<Blog>> getAllBlogs() {
       return ResponseEntity.ok(blogservice.getAllBlogs());
   }
   @GetMapping("/{blogid}")
   public ResponseEntity<Optional<Blog>> getBlogById(@PathVariable("blogid") Long id) {
       return ResponseEntity.ok(blogservice.getBlogById(id));
   }

   @PutMapping("/{blogid}")
   public ResponseEntity<Blog> updateBlog(@PathVariable("blogid") Long id, @RequestBody Blog blog) throws Exception {
       return ResponseEntity.ok(blogservice.updateBlog(id, blog));
   }
   @DeleteMapping("/{blogid}")
   public ResponseEntity<String> deleteBlog(@PathVariable("blogid") Long id) {
       blogservice.deleteBlog(id);
       return ResponseEntity.ok("Blog deleted successfully");
   }
}
