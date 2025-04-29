package com.FreelanceMarketplace.api.repository;


import com.FreelanceMarketplace.api.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByFreelancerId(Long freelancerId);

}