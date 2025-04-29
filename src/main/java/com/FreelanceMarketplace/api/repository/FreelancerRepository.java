package com.FreelanceMarketplace.api.repository;

import com.FreelanceMarketplace.api.entity.Freelancer;
import com.FreelanceMarketplace.api.entity.dto.FreelancerSearchDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {

    @Query("""
    SELECT DISTINCT f FROM Freelancer f
    LEFT JOIN f.designTools d
    LEFT JOIN f.specialties s
    WHERE (:#{#searchDTO.name} IS NULL OR LOWER(f.name) LIKE LOWER(CONCAT('%', :#{#searchDTO.name}, '%')))
    AND (:#{#searchDTO.city} IS NULL OR LOWER(f.city) LIKE LOWER(CONCAT('%', :#{#searchDTO.city}, '%')))
    AND (:#{#searchDTO.freelancerType} IS NULL OR f.freelancerType = :#{#searchDTO.freelancerType})
    AND (:#{#searchDTO.designTools} IS NULL OR d IN (:#{#searchDTO.designTools}))
    AND (:#{#searchDTO.specialties} IS NULL OR s IN (:#{#searchDTO.specialties}))
    """)
    List<Freelancer> searchFreelancers(@Param("searchDTO") FreelancerSearchDTO searchDTO);


}
