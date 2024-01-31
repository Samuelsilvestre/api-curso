package com.api.course.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.mapping.List;
import org.hibernate.sql.ast.tree.from.MappedByTableGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.course.component.Mapper;
import com.api.course.dto.CourseDto;
import com.api.course.exception.GenericException;
import com.api.course.models.Course;
import com.api.course.repository.CourseRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository repository;

    @Autowired
    private Mapper mapper;

    public CourseDto getOne(Long id) {
        return repository.findById(id).map(mapper::getData).orElseThrow(() -> new GenericException(id));

    }

    public List<CourseDto> listAll() {
        return repository.findAll()
            .stream()
            .map(mapper::getData)
            .collect(Collectors.toList());
    }
    
    @Transactional
    public CourseDto create(CourseDto course) {
        var entity = mapper.setData(course);
        return mapper.getData(repository.save(entity));
    }





}




