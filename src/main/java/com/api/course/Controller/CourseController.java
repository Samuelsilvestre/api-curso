package com.api.course.Controller;

import java.util.List;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.course.models.Course;
import com.api.course.repository.CourseRepository;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping(value = "/api")
public class CourseController {
    
    @Autowired
    private CourseRepository repository;
   
    @GetMapping("/get/course")
    public List<Course> listCourse() {
        return repository.findAll();
    }
    
    @GetMapping("/get/course/{id}")
    public ResponseEntity<Course> getId(@PathVariable Long id) {
        return repository.findById(id)
        .map(c -> ResponseEntity.ok().body(c))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/post/course")
    public Course createCourse(@RequestBody @Valid Course course) {
        return repository.save(course);
    }

    @PutMapping("/put/course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody @Valid Course course) {
        return repository.findById(id)
        .map(record -> {
            record.setTitle(course.getTitle());
            record.setCategory(course.getCategory());
            record.setDescription(course.getDescription());
            Course courseUpdate = repository.save(record);
            return ResponseEntity.ok().body(courseUpdate);
        })
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/course/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        return repository.findById(id)
        .map(record -> {
            repository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.noContent().build());

    }



    }


