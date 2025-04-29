package com.FreelanceMarketplace.api.controller;

import com.FreelanceMarketplace.api.entity.Job;
import com.FreelanceMarketplace.api.entity.dto.*;
import com.FreelanceMarketplace.api.service.impl.JobService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/job")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @PostMapping("/createJob")
    public ResponseEntity<String> createJob(@RequestBody JobCreateDTO jobDTO) {
        jobService.createJob(jobDTO);
        return ResponseEntity.ok("Job created");
    }

    @GetMapping("/getJobsOfFreelancer")
    public ResponseEntity<List<JobDTO>> getJobsOfFreelancer(@RequestParam  Long freelancerId) {
        return ResponseEntity.ok(jobService.getJobsOfFreelancer(freelancerId));
    }

    @GetMapping("/getJob")
    public ResponseEntity<JobDTO> getJob(@RequestParam  Long jobId) {
        return ResponseEntity.ok(jobService.getJob(jobId));
    }

    @PostMapping("/updateJob")
    public ResponseEntity<String> updateJob(@RequestBody JobUpdateDTO jobUpdateDTO) {
        jobService.updateJob(jobUpdateDTO);
        return ResponseEntity.ok("Job Updated");
    }


}
