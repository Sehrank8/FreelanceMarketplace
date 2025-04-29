package com.FreelanceMarketplace.api.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Association with Job
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    private String commenterName;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    public Comment(Job job, Date createdDate, String comment) {
        this.job = job;
        this.createdDate = createdDate;
        this.comment = comment;
    }

    private String comment;



    // To automatically set createdDate before adding to the database
    @PrePersist
    public void onCreate() {
        this.createdDate = new Date();
    }

    public Comment() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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