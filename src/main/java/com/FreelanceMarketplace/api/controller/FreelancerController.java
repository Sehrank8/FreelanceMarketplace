package com.FreelanceMarketplace.api.controller;
import com.FreelanceMarketplace.api.entity.dto.FreelancerCreateDTO;
import com.FreelanceMarketplace.api.entity.dto.FreelancerDTO;
import com.FreelanceMarketplace.api.entity.dto.FreelancerSearchDTO;
import com.FreelanceMarketplace.api.service.impl.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/freelancer")
public class FreelancerController {
    private final FreelancerService freelancerService;


    @Autowired
    public FreelancerController(FreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }

    @PostMapping("/createFreelancer")
    public ResponseEntity<String> createFreelancer(@RequestBody FreelancerCreateDTO freelancerDTO) {
        return ResponseEntity.ok(freelancerService.createFreelancer(freelancerDTO));
    }

    @GetMapping("/getAllFreelancers")
    public ResponseEntity<List<FreelancerDTO>> getFreeLancers() {
        return ResponseEntity.ok(freelancerService.getAllFreelancers());
    }

    @GetMapping("/getFreelancer")
    public ResponseEntity<FreelancerDTO> getFreelancer(@RequestParam  Long freelancerId) {
        return ResponseEntity.ok(freelancerService.getFreelancerByID(freelancerId));
    }

    @PostMapping("/searchFreelancer")
    public ResponseEntity<List<FreelancerDTO>> searchFreelancer(@RequestBody FreelancerSearchDTO searchDTO) {
        searchDTO.clean();
        return ResponseEntity.ok(freelancerService.getFreelancerBySearchDTO(searchDTO));
    }

}
