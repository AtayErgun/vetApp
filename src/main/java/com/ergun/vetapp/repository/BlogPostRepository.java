package com.ergun.vetapp.repository;

import com.ergun.vetapp.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {
}
