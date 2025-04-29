package com.FreelanceMarketplace.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String city;

    @Enumerated(EnumType.STRING)
    private FreelancerType freelancerType;

    // Designer-only
    private String portfolioUrl;

    @ElementCollection
    private List<String> designTools;

    // Developer-only
    @ElementCollection
    private List<String> softwareLanguages;

    @ElementCollection
    private List<String> specialties;

    // Integer instead of int to make it nullable,
    // otherwise it would be 0 by default which is not between the 1-10 range
    @Column
    @Min(1)
    @Max(10)
    private Integer evaluationScore;

    // Optional
    @Column(length = 1000)
    private String additionalNotes;

    // Enum for type safety
    public enum FreelancerType {
        SOFTWARE_DEVELOPER,
        DESIGNER
    }


    public Freelancer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public FreelancerType getFreelancerType() {
        return freelancerType;
    }

    public void setFreelancerType(FreelancerType freelancerType) {
        this.freelancerType = freelancerType;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public List<String> getDesignTools() {
        return designTools;
    }

    public void setDesignTools(List<String> designTools) {
        this.designTools = designTools;
    }

    public List<String> getSoftwareLanguages() {
        return softwareLanguages;
    }

    public void setSoftwareLanguages(List<String> softwareLanguages) {
        this.softwareLanguages = softwareLanguages;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }

    public Integer getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(Integer evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}

