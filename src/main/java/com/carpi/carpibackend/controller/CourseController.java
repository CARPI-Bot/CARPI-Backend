package com.carpi.carpibackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.carpi.carpibackend.entity.Course;
import com.carpi.carpibackend.repository.CourseRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @ResponseBody
    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

}
