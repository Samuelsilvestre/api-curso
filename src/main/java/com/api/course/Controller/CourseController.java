package com.api.course.Controller;

import java.util.List;
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

import com.api.course.dto.CourseDto;
import com.api.course.models.Course;
import com.api.course.repository.CourseRepository;
import com.api.course.service.CourseService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping(value = "/api")
public class CourseController {
    
    @Autowired
    private CourseRepository repository;

    @Autowired
    private CourseService service;
   
    @GetMapping("/get/course")
    public List<CourseDto> listCourse() {
        return service.listAll();
    }
    
    @GetMapping("/get/course/{id}")
    public CourseDto getId(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping("/post/course")
    public CourseDto createCourse(@RequestBody @Valid CourseDto course) {
        return service.create(course);
    }

    @PutMapping("/put/course/{id}")
    public CourseDto updateCourse(@PathVariable Long id, @RequestBody @Valid CourseDto course) {
        return service.update(id, course);
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


