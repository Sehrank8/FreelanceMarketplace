package com.FreelanceMarketplace.api;


import com.FreelanceMarketplace.api.entity.Freelancer;
import com.FreelanceMarketplace.api.entity.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Collections;

import static org.hibernate.internal.util.collections.CollectionHelper.listOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FreelancerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCreateFreelancer() throws Exception {
		var freelancer = new FreelancerCreateDTO("Bob", "bob@example.com",
				"123456789","Izmir", "SOFTWARE_DEVELOPER",
				"https://portfolio.com"  , listOf("photoshop"),listOf("c"),listOf("backend"),"adwwad");

		mockMvc.perform(post("/api/freelancer/createFreelancer")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(freelancer)))
				.andExpect(status().isOk());
	}

	@Test
	void testGetAllFreelancers() throws Exception {
		mockMvc.perform(get("/api/freelancer/getAllFreelancers"))
				.andExpect(status().isOk());
	}

	@Test
	void testGetFreelancer() throws Exception {
		mockMvc.perform(get("/api/freelancer/getFreelancer")
						.param("freelancerId", "1"))
				.andExpect(status().isOk());
	}
	@Test
	void testGetFreelancerNotFound() throws Exception {
		mockMvc.perform(get("/api/freelancer/getFreelancer")
						.param("freelancerId", "999"))
				.andExpect(status().isNotFound())
				.andExpect(content().string(org.hamcrest.Matchers.containsString("Freelancer: 8 not found")));
	}


	@Test
	void testSearchFreelancer() throws Exception {
		var searchDto = new FreelancerSearchDTO("Bob", "Izmir", Freelancer.FreelancerType.SOFTWARE_DEVELOPER, null, null);

		mockMvc.perform(post("/api/freelancer/searchFreelancer")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(searchDto)))
				.andExpect(status().isOk());
	}
}



@SpringBootTest
@AutoConfigureMockMvc
class JobControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCreateJob() throws Exception {
		var jobCreateDTO = new JobCreateDTO(1L, "First job", "IN_PROGRESS");

		mockMvc.perform(post("/api/job/createJob")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(jobCreateDTO)))
				.andExpect(status().isOk());
	}

	@Test
	void testGetJobs() throws Exception {
		mockMvc.perform(get("/api/job/getJobsOfFreelancer")
						.param("freelancerId", "1"))
				.andExpect(status().isOk());
	}

	@Test
	void testGetJob() throws Exception {
		mockMvc.perform(get("/api/job/getJob")
						.param("jobId", "1"))
				.andExpect(status().isOk());
	}
	@Test
	void testGetJobNotFound() throws Exception {
		mockMvc.perform(get("/api/job/getJob")
						.param("jobId", "999"))
				.andExpect(status().isNotFound());
	}


	@Test
	void testUpdateJob() throws Exception {
		var updateDto = new JobUpdateDTO(1L, "Updated description", "IN_PROGRESS");

		mockMvc.perform(post("/api/job/updateJob")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(updateDto)))
				.andExpect(status().isOk());
	}
}
@SpringBootTest
@AutoConfigureMockMvc
class CommentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCreateComment() throws Exception {
		CommentCreateDTO createDTO = new CommentCreateDTO(1L, "TestUser", "This is a test comment");

		mockMvc.perform(post("/api/comment/createComment")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(createDTO)))
				.andExpect(status().isOk());
	}

	@Test
	void testGetCommentsOfJob() throws Exception {
		mockMvc.perform(get("/api/comment/getCommentsOfJob")
						.param("jobId", "1"))
				.andExpect(status().isOk());
	}


	@Test
	void testUpdateComment() throws Exception {
		CommentUpdateDTO updateDTO = new CommentUpdateDTO("Updated Comment Text",1L );

		mockMvc.perform(post("/api/comment/updateComment")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(updateDTO)))
				.andExpect(status().isOk());
	}
}
