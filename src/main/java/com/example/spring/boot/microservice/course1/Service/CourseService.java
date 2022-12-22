package com.example.spring.boot.microservice.course1.Service;

import com.example.spring.boot.microservice.course1.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService
{



    Course saveCourse(Course course);

    void deleteCourse(Long courseId);

    List<Course> findAllCourses();
}
