package com.carpi.carpibackend.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.carpi.carpibackend.entity.Course;
import com.carpi.carpibackend.repository.CourseRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

}
