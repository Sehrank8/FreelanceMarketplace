package com.FreelanceMarketplace.api.entity.dto;

import com.FreelanceMarketplace.api.entity.Job;
import io.swagger.v3.oas.annotations.media.Schema;

public class JobUpdateDTO {
    @Schema(example = "1")
    private Long id;
    private String description;
    private String status;

    public JobUpdateDTO(Long id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
