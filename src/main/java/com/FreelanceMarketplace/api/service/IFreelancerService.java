package com.FreelanceMarketplace.api.service;


import com.FreelanceMarketplace.api.entity.dto.FreelancerCreateDTO;
import com.FreelanceMarketplace.api.entity.dto.FreelancerDTO;
import com.FreelanceMarketplace.api.entity.dto.FreelancerSearchDTO;

import java.util.List;

public interface IFreelancerService {
    String createFreelancer(FreelancerCreateDTO freelancerDTO);

    List<FreelancerDTO> getAllFreelancers();

    FreelancerDTO getFreelancerByID(Long freelancerId);

    List<FreelancerDTO> getFreelancerBySearchDTO(FreelancerSearchDTO freelancerSearchDTO);

}
