# Freelance Marketplace API

This is a RESTful API for a **Freelance Marketplace**, developed in **Java Spring Boot**, using **PostgreSQL** as the database and **RabbitMQ** for asynchronous processing. It provides endpoints for managing freelancers, jobs, and comments.

My deployed instance on Render.com(it will take a few seconds to boot up): [https://freelancemarketplace.onrender.com/swagger-ui/index.html#/](https://freelancemarketplace.onrender.com/swagger-ui/index.html#/)
## Features

- **Freelancer Management**: Create, list, and search freelancers. Freelancer type can only be (`SOFTWARE_DEVELOPER` or `DESIGNER`)
- **Job Management**: Assign jobs to freelancers, update or fetch job details. Job status can only be (`IN_PROGRESS`, `CANCELLED`, `FINISHED`)
- **Comment System**: Users can post comments on jobs.
- **Asynchronous Evaluation System**: When a new freelancer is created, an evaluation job is sent through **RabbitMQ** to score them asynchronously.
- **Database Seeding**: Automatically seeds the database with sample freelancers, jobs, and comments.(If the DB is empty)

## Technologies Used

- Java 17
- Spring Boot 3.4.5
- PostgreSQL
- RabbitMQ
- Maven
- Docker (Optional Deployment)

---

## 📁 Project Structure
- `entity/`: Data models and DTOs
- `controller/`: REST controllers
- `service/`: Business logic
- `repository/`: JPA interfaces
- `config/`: Configuration beans and seeders

---

## Endpoints

All endpoints are prefixed with `/api`

### Freelancer Endpoints

- `POST /freelancer/createFreelancer`  
  Create a new freelancer. This triggers an asynchronous evaluation via RabbitMQ.

- `GET /freelancer/getFreelancer?freelancerId=<long>`  
  Fetch details of a specific freelancer.

- `GET /freelancer/getAllFreelancers`  
  Fetch all freelancers.

- `POST /freelancer/searchFreelancer`  
  Search freelancers by various filters.

#### Example: Search Freelancer

```json
{
  "name": "Alice",
  "city": "Istanbul",
  "freelancerType": "SOFTWARE_DEVELOPER",
  "designTools": ["Figma"],
  "specialties": ["UI/UX Design"]
}
```

### Job Endpoints

- `POST /job/createJob`  
  Assign a new job to a freelancer.

- `POST /job/updateJob`  
  Update a job’s status or description.

- `GET /job/getJobsOfFreelancer?freelancerId=<long>`  
  Retrieve all jobs for a freelancer.

- `GET /job/getJob?jobId=<long>`  
  Retrieve details of a specific job.


#### Example: Create Job

```json
{
  "freelancerId": 1,
  "description": "Build a landing page",
  "status": "IN_PROGRESS"
}
```


### Comment Endpoints

- `POST /comment/createComment`  
  Post a comment on a job.

- `POST /comment/updateComment`  
  Update a comment.

- `GET /comment/getCommentsOfJob?jobId=<long>`  
  List all comments for a job.


#### Example: Search Freelancer

```json
{
  "name": "Alice",
  "city": "Istanbul",
  "freelancerType": "SOFTWARE_DEVELOPER",
  "designTools": ["Figma"],
  "specialties": ["UI/UX Design"]
}
```

---

## RabbitMQ Integration

When a new freelancer is created, a message is published to a RabbitMQ queue to **calculate an evaluation score asynchronously**. This helps to offload compute-heavy tasks without delaying user responses.

---

## Docker Support

You can containerize the application and database using Docker:

```bash
docker-compose up --build
```

Make sure your `.env` file includes:
```
DB_HOST=your_dbhost
DB_PORT=your_db_port
DB_NAME=your database name
DB_USERNAME=yourusername
DB_PASSWORD=yourpassword

RABBITMQ_HOST=your_rabbit_host
RABBITMQ_USERNAME=your_rabbit_user
RABBITMQ_PASSWORD=your_rabbit_pass
RABBITMQ_PORT=5671
```

---

## Postman Collection and Swagger

The API can be tested using the [Postman Collection](https://cloudy-robot-2897016.postman.co/workspace/%C5%9Eehran-Kartal's-Workspace~9c0b2215-fd79-4fc9-8227-dec40ddf544c/collection/43476226-045b7f1d-7667-483f-a44d-eb6e4c1905ef?action=share&source=collection_link&creator=43476226).

Or after running the api locally [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

Or even on my deployed instance on Render.com(it will take a few seconds to boot up): [https://freelancemarketplace.onrender.com/swagger-ui/index.html#/](https://freelancemarketplace.onrender.com/swagger-ui/index.html#/)

---
