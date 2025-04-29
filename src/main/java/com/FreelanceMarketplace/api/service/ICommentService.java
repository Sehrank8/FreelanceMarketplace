package com.FreelanceMarketplace.api.service;

import com.FreelanceMarketplace.api.entity.dto.CommentCreateDTO;
import com.FreelanceMarketplace.api.entity.dto.CommentDTO;
import com.FreelanceMarketplace.api.entity.dto.CommentUpdateDTO;

import java.util.List;

public interface ICommentService {
    void createComment(CommentCreateDTO commentDTO);

    List<CommentDTO> getCommentsByJob(Long jobId);

    void updateComment(CommentUpdateDTO commentUpdateDTO);

}
