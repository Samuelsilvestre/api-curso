package com.api.course.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.course.models.Course;
import com.api.course.repository.CourseRepository;

@RestController
@RequestMapping(value = "/api")
public class CourseController {
    
    @Autowired
    private CourseRepository repository;
   
    @GetMapping("/get/course/{id}")
    public ResponseEntity<Course> getId(@PathVariable Long id) {
        return repository.findById(id)
        .map(c -> ResponseEntity.ok().body(c))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/post/course")
    public Course createCourse(@RequestBody Course course) {
        return repository.save(course);
    }
}