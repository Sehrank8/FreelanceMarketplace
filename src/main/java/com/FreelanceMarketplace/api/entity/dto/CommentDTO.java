package com.FreelanceMarketplace.api.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class CommentDTO {


    @Schema(example = "1")
    private Long id;
    @Schema(example = "1")
    private Long jobId;
    private String commenterName;
    @Schema(example = "2025-04-28")
    private Date createdDate;
    private String comment;


    public CommentDTO(Long id, Long jobId, String commenterName, Date createdDate, String comment) {
        this.id =id;
        this.jobId = jobId;
        this.commenterName = commenterName;
        this.createdDate = createdDate;
        this.comment = comment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
