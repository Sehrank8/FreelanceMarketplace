package com.FreelanceMarketplace.api.entity.dto;


import io.swagger.v3.oas.annotations.media.Schema;

public class CommentCreateDTO {
    @Schema(example = "1")
    private Long jobId;
    private String commenterName;
    private String comment;

    public CommentCreateDTO(Long jobId, String commenterName, String comment) {
        this.jobId = jobId;
        this.commenterName = commenterName;
        this.comment = comment;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
