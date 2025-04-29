package com.FreelanceMarketplace.api.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class JobDTO {

    @Schema(example = "1")
    private Long id;
    @Schema(example = "1")
    private Long freelancerId;
    private String description;
    private String status;      // Job status (in-progress, finished, canceled)
    @Schema(example = "2025-04-28")
    private Date createdDate;

    public JobDTO(Long id,Long freelancerId, String description, String status, Date createdDate) {
        this.id=id;
        this.freelancerId = freelancerId;
        this.description = description;
        this.status = status;
        this.createdDate = createdDate;
    }

    public JobDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(Long freelancerId) {
        this.freelancerId = freelancerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
