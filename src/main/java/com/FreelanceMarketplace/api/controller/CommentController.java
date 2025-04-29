package com.FreelanceMarketplace.api.controller;

import com.FreelanceMarketplace.api.entity.Job;
import com.FreelanceMarketplace.api.entity.dto.CommentCreateDTO;
import com.FreelanceMarketplace.api.entity.dto.CommentDTO;
import com.FreelanceMarketplace.api.entity.dto.CommentUpdateDTO;
import com.FreelanceMarketplace.api.entity.dto.JobDTO;
import com.FreelanceMarketplace.api.service.impl.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/createComment")
    public ResponseEntity<String> createComment(@RequestBody CommentCreateDTO commentDTO) {
        commentService.createComment(commentDTO);
        return ResponseEntity.ok("Comment created");
    }

    @GetMapping("/getCommentsOfJob")
    public ResponseEntity<List<CommentDTO>> getCommentsOfJob(@RequestParam  Long jobId) {
        return ResponseEntity.ok(commentService.getCommentsByJob(jobId));
    }

    @PostMapping("/updateComment")
    public ResponseEntity<String> updateComment(@RequestBody CommentUpdateDTO commentUpdateDTO) {
        commentService.updateComment(commentUpdateDTO);
        return ResponseEntity.ok("Comment Updated");
    }
}
