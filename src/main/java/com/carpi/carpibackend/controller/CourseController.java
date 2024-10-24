package com.carpi.carpibackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.carpi.carpibackend.entity.Course;
import com.carpi.carpibackend.entity.CourseSearchResult;
import com.carpi.carpibackend.repository.CourseRepository;
import com.carpi.carpibackend.service.CourseSearchService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseSearchService courseSearchService;

    @ResponseBody
    @GetMapping("getAll")
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

    @ResponseBody
    @GetMapping("search/{searchTerm}")
    public ResponseEntity<List<CourseSearchResult>> searchCourse(@PathVariable String searchTerm) {
        return ResponseEntity.ok(courseSearchService.searchCourse(searchTerm));
    }
}
