package com.FreelanceMarketplace.api.entity.dto;

import com.FreelanceMarketplace.api.entity.Freelancer;


import java.util.List;
import java.util.stream.Collectors;

public class FreelancerSearchDTO {
    private String name;
    private String city;
    private Freelancer.FreelancerType freelancerType;
    private List<String> designTools; // For Designers only
    private List<String> specialties; // For Developers only


    public FreelancerSearchDTO(String name, String city, Freelancer.FreelancerType freelancerType, List<String> designTools, List<String> specialties) {
        this.name = name;
        this.city = city;
        this.freelancerType = freelancerType;
        this.designTools = designTools;
        this.specialties = specialties;
    }


    // To make sure when searching for a freelancer, if design tools or specialities are entered as "" they get turned into null
    public void clean() {
        if (designTools != null) {
            designTools = designTools.stream()
                    .filter(tool -> tool != null && !tool.trim().isEmpty())
                    .collect(Collectors.toList());
            if (designTools.isEmpty()) {
                designTools = null;
            }
        }

        if (specialties != null) {
            specialties = specialties.stream()
                    .filter(spec -> spec != null && !spec.trim().isEmpty())
                    .collect(Collectors.toList());
            if (specialties.isEmpty()) {
                specialties = null;
            }
        }
        if (freelancerType != null && freelancerType.toString().isBlank()) {
            freelancerType = null;
        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Freelancer.FreelancerType getFreelancerType() {
        return freelancerType;
    }

    public void setFreelancerType(Freelancer.FreelancerType freelancerType) {
        this.freelancerType = freelancerType;
    }

    public List<String> getDesignTools() {
        return designTools;
    }

    public void setDesignTools(List<String> designTools) {
        this.designTools = designTools;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }
}
