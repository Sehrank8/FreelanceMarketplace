package com.FreelanceMarketplace.api.service.impl;

import com.FreelanceMarketplace.api.entity.dto.JobCreateDTO;
import com.FreelanceMarketplace.api.entity.dto.JobUpdateDTO;
import com.FreelanceMarketplace.api.service.IJobService;
import com.FreelanceMarketplace.api.entity.Job;
import com.FreelanceMarketplace.api.entity.dto.JobDTO;
import com.FreelanceMarketplace.api.repository.FreelancerRepository;
import com.FreelanceMarketplace.api.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService implements IJobService {
    private final JobRepository jobRepository;
    private final FreelancerRepository freelancerRepository;

    public JobService(JobRepository jobRepository, FreelancerRepository freelancerRepository) {
        this.jobRepository = jobRepository;
        this.freelancerRepository = freelancerRepository;
    }

    @Override
    public void createJob(JobCreateDTO jobDTO) {
        Job job = new Job();

        job.setJobStatus(Job.JobStatus.valueOf(jobDTO.getStatus()));
        job.setDescription(jobDTO.getDescription());
        job.setFreelancer(freelancerRepository.findById(jobDTO.getFreelancerId()).
                orElseThrow(() -> new RuntimeException("Freelancer: " + jobDTO.getFreelancerId() + " not found")));

        jobRepository.save(job);
    }

    @Override
    public List<JobDTO> getJobsOfFreelancer(Long freelancerId) {
        List<Job> jobs = jobRepository.findByFreelancerId(freelancerId);

        return jobs.stream()
                .map(job -> new JobDTO(
                        job.getId(),
                        freelancerId,
                        job.getDescription(),
                        job.getJobStatus().toString(),
                        job.getCreatedDate()
                ))
                .collect(Collectors.toList());
    }



    @Override
    public JobDTO getJob(Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job : " + jobId + " not found."));

        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(jobId);
        jobDTO.setDescription(job.getDescription());
        jobDTO.setFreelancerId(job.getFreelancer().getId());
        jobDTO.setStatus(String.valueOf(job.getJobStatus()));
        jobDTO.setCreatedDate(job.getCreatedDate());

        return jobDTO;
    }

    @Override
    public void updateJob(JobUpdateDTO jobUpdateDTO) {
        Job job = jobRepository.findById(jobUpdateDTO.getId())
                .orElseThrow(() -> new RuntimeException("Job : " + jobUpdateDTO.getId() + " not found."));

        job.setJobStatus(Job.JobStatus.valueOf(jobUpdateDTO.getStatus()));

        if (jobUpdateDTO.getDescription() != null && !jobUpdateDTO.getDescription().equalsIgnoreCase("string")) {
            job.setDescription(jobUpdateDTO.getDescription());
        }

        jobRepository.save(job);
    }
}
