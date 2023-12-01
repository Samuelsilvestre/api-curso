package com.api.course.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.course.models.Course;
import com.api.course.repository.CourseRepository;

@RestController
@RequestMapping("/api")
public class CourseController {
    
    @Autowired
    private CourseRepository repository;

    @RequestMapping(value = "HTTP_CREATED")
    @PostMapping("post/course")
    public Course createCourse(@RequestBody Course course) {
        return repository.save(course);
    }
}
