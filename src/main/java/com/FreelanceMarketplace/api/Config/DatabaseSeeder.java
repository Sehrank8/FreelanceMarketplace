package com.FreelanceMarketplace.api.Config;

import com.FreelanceMarketplace.api.entity.Job;
import com.FreelanceMarketplace.api.entity.Freelancer;
import com.FreelanceMarketplace.api.entity.dto.CommentCreateDTO;
import com.FreelanceMarketplace.api.entity.dto.FreelancerCreateDTO;
import com.FreelanceMarketplace.api.entity.dto.JobCreateDTO;
import com.FreelanceMarketplace.api.repository.FreelancerRepository;
import com.FreelanceMarketplace.api.repository.JobRepository;
import com.FreelanceMarketplace.api.service.impl.CommentService;
import com.FreelanceMarketplace.api.service.impl.FreelancerService;
import com.FreelanceMarketplace.api.service.impl.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {


    @Autowired
    private final FreelancerService freelancerService;
    @Autowired
    private final JobService jobService;
    @Autowired
    private final CommentService commentService;
    @Autowired
    private final FreelancerRepository freelancerRepository;
    @Autowired
    private final JobRepository jobRepository;

    @Autowired
    public DatabaseSeeder(FreelancerService freelancerService, JobService jobService, CommentService commentService, FreelancerRepository freelancerRepository, JobRepository jobRepository) {
        this.freelancerService = freelancerService;
        this.jobService = jobService;
        this.commentService = commentService;
        this.freelancerRepository = freelancerRepository;
        this.jobRepository = jobRepository;
    }


    public void seedDatabase() {
        if (!freelancerRepository.findAll().isEmpty()) {
            return;
        }


        List<FreelancerCreateDTO> freelancerDTOS = List.of(
                new FreelancerCreateDTO(
                        "Alice Smith",
                        "alice@example.com",
                        "555-1234",
                        "Istanbul",
                        "DESIGNER",
                        "https://portfolio.alice.com",
                        List.of("Photoshop", "Illustrator", "Figma"),
                        null,
                        List.of("Branding", "UI/UX Design"),
                        "Experienced creative designer for tech startups."
                ),
                new FreelancerCreateDTO(
                        "Diana Prince",
                        "diana@example.com",
                        "555-5678",
                        "Ankara",
                        "DESIGNER",
                        "https://portfolio.diana.com",
                        List.of("Sketch", "InDesign"),
                        null,
                        List.of("Mobile UI Design", "Website Redesign"),
                        "Award-winning UX/UI designer."
                ),
                new FreelancerCreateDTO(
                        "Bob Johnson",
                        "bob@example.com",
                        "555-9012",
                        "Izmir",
                        "SOFTWARE_DEVELOPER",
                        null,
                        null,
                        List.of("Java", "Spring Boot", "SQL"),
                        List.of("Backend Development", "API Integration"),
                        "Senior backend developer with microservices expertise."
                ),
                new FreelancerCreateDTO(
                        "Charlie Rose",
                        "charlie@example.com",
                        "555-3456",
                        "Bursa",
                        "SOFTWARE_DEVELOPER",
                        null,
                        null,
                        List.of("Python", "Django", "Machine Learning"),
                        List.of("Data Science", "AI Engineering"),
                        "Building predictive models and intelligent systems."
                )
        );

        for (FreelancerCreateDTO freelancer : freelancerDTOS) {
            freelancerService.createFreelancer(freelancer);
        }


            List<Freelancer> freelancers = freelancerRepository.findAll();

            jobService.createJob(new JobCreateDTO(freelancers.get(0).getId(), "Build backend API", "IN_PROGRESS"));
            jobService.createJob(new JobCreateDTO(freelancers.get(1).getId(), "Create UI/UX Mockups", "CANCELLED"));
            jobService.createJob(new JobCreateDTO(freelancers.get(2).getId(), "Implement OAuth2", "CANCELLED"));
            jobService.createJob(new JobCreateDTO(freelancers.get(1).getId(), "Design Landing Page", "IN_PROGRESS"));
            jobService.createJob(new JobCreateDTO(freelancers.get(3).getId(), "Create Branding Kit", "FINISHED"));
            jobService.createJob(new JobCreateDTO(freelancers.get(0).getId(), "Database Schema Optimization", "FINISHED"));

            List<Job> jobs = jobRepository.findAll();

        List<CommentCreateDTO> comments = List.of(
                new CommentCreateDTO(1L, "John Doe", "Excellent design work!"),
                new CommentCreateDTO(1L, "Jane Smith", "Great attention to detail."),
                new CommentCreateDTO(2L, "Mike Brown", "Fast delivery and very professional."),
                new CommentCreateDTO(3L, "Sarah Lee", "Resolved all backend issues perfectly."),
                new CommentCreateDTO(4L, "Alan Turing", "Amazing AI modeling skills!"),
                new CommentCreateDTO(4L, "Ada Lovelace", "Groundbreaking innovation."),
                new CommentCreateDTO(5L, "Steve Jobs", "Love the new layout!"),
                new CommentCreateDTO(6L, "Bill Gates", "Project canceled but communication was great."),
                new CommentCreateDTO(2L, "Grace Hopper", "Would hire again."),
                new CommentCreateDTO(3L, "Tim Berners-Lee", "Top-notch work!")
        );

        for (CommentCreateDTO comment : comments) {
            commentService.createComment(comment);
        }

    }

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();
    }
}
