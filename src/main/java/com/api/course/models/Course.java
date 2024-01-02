package com.api.course.models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLSelect;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "course")
@SQLDelete(sql = "UPDATE course SET status='Inativo' where id=? ")
@SQLSelect(sql = "SELECT * FROM course where status='Ativo' ")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @NotBlank
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String title;
    
    @NotNull
    @NotBlank
    @Length(max = 25)
    @Column(length = 25, nullable = false)
    private String category;
    
    @NotNull
    @NotBlank
    @Length(max = 250)
    @Column(length = 200, nullable = false)
    private String description;

    @Length(max = 7)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(name = "status")
    private String status = "Ativo";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
