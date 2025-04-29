package com.FreelanceMarketplace.api.service.impl;

import com.FreelanceMarketplace.api.entity.dto.FreelancerCreateDTO;
import com.FreelanceMarketplace.api.service.IFreelancerService;
import com.FreelanceMarketplace.api.entity.Freelancer;
import com.FreelanceMarketplace.api.entity.dto.FreelancerDTO;
import com.FreelanceMarketplace.api.entity.dto.FreelancerSearchDTO;
import com.FreelanceMarketplace.api.repository.FreelancerRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.stream.Collectors;

@Service
public class FreelancerService implements IFreelancerService {
    private final FreelancerRepository freelancerRepository;
    private final RabbitTemplate rabbitTemplate;

    public FreelancerService(FreelancerRepository freelancerRepository, RabbitTemplate rabbitTemplate) {
        this.freelancerRepository = freelancerRepository;
        this.rabbitTemplate = rabbitTemplate;
    }
    @Value("${freelancer.evaluation.queue}")
    private String evaluationQueue;

    @Override
    @Transactional
    public String createFreelancer(FreelancerCreateDTO freelancerDTO) {
        Freelancer freelancer = new Freelancer();
        freelancer.setFreelancerType(Freelancer.FreelancerType.valueOf(freelancerDTO.getFreelancerType()));
        freelancer.setCity(freelancerDTO.getCity());
        freelancer.setEmail(freelancerDTO.getEmail());
        freelancer.setName(freelancerDTO.getName());
        freelancer.setAdditionalNotes(freelancerDTO.getAdditionalNotes());
        freelancer.setDesignTools(freelancerDTO.getDesignTools());
        freelancer.setPortfolioUrl(freelancerDTO.getPortfolioUrl());
        freelancer.setPhone(freelancerDTO.getPhone());
        freelancer.setSoftwareLanguages(freelancerDTO.getSoftwareLanguages());
        freelancer.setSpecialties(freelancerDTO.getSpecialties());
        Freelancer savedFreelancer = freelancerRepository.save(freelancer);
        rabbitTemplate.convertAndSend(evaluationQueue, savedFreelancer.getId());

        return "Freelancer Successfully Created";

    }

    @Override
    public List<FreelancerDTO> getAllFreelancers() {
        List<Freelancer> freelancers = freelancerRepository.findAll();
        return freelancers.stream()
                .map(freelancer -> new FreelancerDTO(
                        freelancer.getId(),
                        freelancer.getName(),
                        freelancer.getEmail(),
                        freelancer.getPhone(),
                        freelancer.getCity(),
                        freelancer.getFreelancerType(),
                        freelancer.getPortfolioUrl(),
                        freelancer.getDesignTools(),
                        freelancer.getSoftwareLanguages(),
                        freelancer.getSpecialties(),
                        freelancer.getEvaluationScore(),
                        freelancer.getAdditionalNotes()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public FreelancerDTO getFreelancerByID(Long freelancerId) {
        Freelancer freelancer = freelancerRepository.findById(freelancerId).
                orElseThrow(() -> new RuntimeException("Freelancer: " + freelancerId + " not found"));

        return new FreelancerDTO(
                freelancer.getId(),
                freelancer.getName(),
                freelancer.getEmail(),
                freelancer.getPhone(),
                freelancer.getCity(),
                freelancer.getFreelancerType(),
                freelancer.getPortfolioUrl(),
                freelancer.getDesignTools(),
                freelancer.getSoftwareLanguages(),
                freelancer.getSpecialties(),
                freelancer.getEvaluationScore(),
                freelancer.getAdditionalNotes()
        );
    }

    @Override
    public List<FreelancerDTO> getFreelancerBySearchDTO(FreelancerSearchDTO freelancerSearchDTO) {

        List<Freelancer> freelancers = freelancerRepository.searchFreelancers(freelancerSearchDTO);

        return freelancers.stream()
                .map(freelancer -> new FreelancerDTO(
                        freelancer.getId(),
                        freelancer.getName(),
                        freelancer.getEmail(),
                        freelancer.getPhone(),
                        freelancer.getCity(),
                        freelancer.getFreelancerType(),
                        freelancer.getPortfolioUrl(),
                        freelancer.getDesignTools(),
                        freelancer.getSoftwareLanguages(),
                        freelancer.getSpecialties(),
                        freelancer.getEvaluationScore(),
                        freelancer.getAdditionalNotes()
                ))
                .collect(Collectors.toList());
    }


}
