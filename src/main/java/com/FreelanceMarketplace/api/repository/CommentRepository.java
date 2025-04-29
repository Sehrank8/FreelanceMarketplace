package com.FreelanceMarketplace.api.repository;

import com.FreelanceMarketplace.api.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByJobId(Long jobId);

}
