package com.api.course.component;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.api.course.dto.CourseDto;
import com.api.course.models.Course;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Component
public class Mapper {
    
    public CourseDto getData(Course course) {
        return new CourseDto(course.getTitle(), course.getCategory(), course.getDescription());

    }
    
    public Course setData(CourseDto course) {
        var model = new Course();
        
        model.setTitle(course.title());
        model.setCategory(course.category());
        model.setDescription(course.description());
        return model;
    }
}
