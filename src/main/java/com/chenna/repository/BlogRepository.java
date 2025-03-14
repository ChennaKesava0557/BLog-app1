package com.chenna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chenna.model.Blog;

public interface BlogRepository  extends JpaRepository<Blog ,Long>
{

}
