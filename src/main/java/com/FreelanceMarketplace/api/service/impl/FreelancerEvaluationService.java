package com.FreelanceMarketplace.api.service.impl;

import com.FreelanceMarketplace.api.Config.RabbitMQConfiguration;
import com.FreelanceMarketplace.api.entity.Freelancer;
import com.FreelanceMarketplace.api.repository.FreelancerRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class FreelancerEvaluationService {

    @Autowired
    private FreelancerRepository freelancerRepository;

    @RabbitListener(queues = RabbitMQConfiguration.EVALUATION_QUEUE)
    @Transactional
    public void evaluateFreelancer(Long freelancerId) {

        Freelancer freelancer = freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new RuntimeException("Freelancer not found") {
                });

        Integer evaluationScore = performEvaluation(freelancer);

        freelancer.setEvaluationScore(evaluationScore);
        freelancerRepository.save(freelancer);

    }

    private Integer performEvaluation(Freelancer freelancer) {
        int evaluationScore = 1;
        if (freelancer.getFreelancerType() == Freelancer.FreelancerType.SOFTWARE_DEVELOPER) {
            evaluationScore = freelancer.getSpecialties().size() * freelancer.getSoftwareLanguages().size();
        }
        else {
            evaluationScore = freelancer.getDesignTools().size();
        }
        evaluationScore = Math.max(1, evaluationScore);
        evaluationScore = Math.min(10, evaluationScore);

        return evaluationScore;
    }
}


