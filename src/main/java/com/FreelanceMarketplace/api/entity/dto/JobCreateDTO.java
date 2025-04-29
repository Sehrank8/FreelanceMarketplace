package com.FreelanceMarketplace.api.entity.dto;


import io.swagger.v3.oas.annotations.media.Schema;

public class JobCreateDTO {
    @Schema(example = "1")
    private Long freelancerId;
    private String description;
    private String status;      // Job status (in-progress, finished, canceled)

    public JobCreateDTO(Long freelancerId, String description, String status) {
        this.freelancerId = freelancerId;
        this.description = description;
        this.status = status;
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
}
