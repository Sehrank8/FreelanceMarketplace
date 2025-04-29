package com.FreelanceMarketplace.api.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Association with Freelancer
    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = false)
    private Freelancer freelancer;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobStatus jobStatus;

    @Column(length = 1000)
    private String description;

    public enum JobStatus {
        IN_PROGRESS,
        FINISHED,
        CANCELLED
    }

    public Job() {
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Job(Freelancer freelancer, Date createdDate, JobStatus jobStatus, String description) {
        this.freelancer = freelancer;
        this.createdDate = createdDate;
        this.jobStatus = jobStatus;
        this.description = description;
    }

    @PrePersist
    public void onCreate() {
        this.createdDate = new Date();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
