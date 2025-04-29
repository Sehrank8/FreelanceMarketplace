package com.FreelanceMarketplace.api.entity.dto;

import com.FreelanceMarketplace.api.entity.Freelancer.FreelancerType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FreelancerDTO {

    @Schema(example = "1")
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String city;
    private FreelancerType freelancerType;
    private String portfolioUrl; // For Designers only
    private List<String> designTools; // For Designers only
    private List<String> softwareLanguages; // For Developers only
    private List<String> specialties; // For Developers only
    @Schema(example = "5")
    private Integer evaluationScore;
    private String additionalNotes;

    public FreelancerDTO() {
    }

    public FreelancerDTO(Long id,String name, String email, String phone, String city, FreelancerType freelancerType, String portfolioUrl, List<String> designTools, List<String> softwareLanguages, List<String> specialties, Integer evaluationScore, String additionalNotes) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.freelancerType = freelancerType;
        this.portfolioUrl = portfolioUrl;
        this.designTools = designTools;
        this.softwareLanguages = softwareLanguages;
        this.specialties = specialties;
        this.evaluationScore = evaluationScore;
        this.additionalNotes = additionalNotes;
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
