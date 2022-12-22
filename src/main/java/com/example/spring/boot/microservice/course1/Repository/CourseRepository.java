package com.example.spring.boot.microservice.course1.Repository;

import com.example.spring.boot.microservice.course1.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
