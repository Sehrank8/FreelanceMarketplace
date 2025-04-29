package com.FreelanceMarketplace.api.service.impl;
import com.FreelanceMarketplace.api.entity.dto.CommentCreateDTO;
import com.FreelanceMarketplace.api.entity.dto.CommentUpdateDTO;
import com.FreelanceMarketplace.api.service.ICommentService;
import com.FreelanceMarketplace.api.entity.Comment;
import com.FreelanceMarketplace.api.entity.Job;
import com.FreelanceMarketplace.api.entity.dto.CommentDTO;
import com.FreelanceMarketplace.api.repository.CommentRepository;
import com.FreelanceMarketplace.api.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private final JobRepository jobRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, JobRepository jobRepository) {
        this.commentRepository = commentRepository;
        this.jobRepository = jobRepository;
    }


    @Override
    public void createComment(CommentCreateDTO commentDTO) {
        Comment comment = new Comment();
        comment.setComment(commentDTO.getComment());
        comment.setCommenterName(commentDTO.getCommenterName());
        Job job = jobRepository.findById(commentDTO.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + commentDTO.getJobId()));
        comment.setJob(job);

        commentRepository.save(comment);

    }

    @Override
    public List<CommentDTO> getCommentsByJob(Long jobId) {
        List<Comment> comments = commentRepository.findByJobId(jobId);
        return comments.stream()
                .map(comment -> new CommentDTO(
                        comment.getId(),
                        jobId,
                        comment.getCommenterName(),
                        comment.getCreatedDate(),
                        comment.getComment()))
                .collect(Collectors.toList());
    }
        @Override
        public void updateComment (CommentUpdateDTO commentUpdateDTO){
            Comment comment = commentRepository.findById(commentUpdateDTO.getId()).
                    orElseThrow(() -> new RuntimeException("Comment: " + commentUpdateDTO.getId() + " not found."));
            comment.setComment(commentUpdateDTO.getComment());

            commentRepository.save(comment);
        }
    }
