package com.FreelanceMarketplace.api.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class CommentUpdateDTO {

    @Schema(example = "1")
    private Long id;
    private String comment;

    public CommentUpdateDTO(String comment, Long id) {
        this.comment = comment;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
