package com.FreelanceMarketplace.api.service;


import com.FreelanceMarketplace.api.entity.Job;
import com.FreelanceMarketplace.api.entity.dto.JobCreateDTO;
import com.FreelanceMarketplace.api.entity.dto.JobDTO;
import com.FreelanceMarketplace.api.entity.dto.JobUpdateDTO;

import java.util.List;

public interface IJobService {
    void createJob(JobCreateDTO jobDTO);

    List<JobDTO> getJobsOfFreelancer(Long FreelancerId);

    JobDTO getJob(Long jobId);

    void updateJob(JobUpdateDTO jobUpdateDTO);

}
