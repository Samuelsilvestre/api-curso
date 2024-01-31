package com.api.course.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseDto(
    
   @NotNull @NotBlank @Length(max = 50) String title,

   @NotNull @NotBlank @Length(max = 25) String category,

   @NotNull @NotBlank @Length(max = 250) String description
) {
    
}
