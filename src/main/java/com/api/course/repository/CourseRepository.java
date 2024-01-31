package com.api.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.course.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}

