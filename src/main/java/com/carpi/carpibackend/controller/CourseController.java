package com.carpi.carpibackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carpi.carpibackend.dto.CourseDto;
import com.carpi.carpibackend.entity.CourseSearchResult;
import com.carpi.carpibackend.projection.CourseAttributeProjection;
import com.carpi.carpibackend.projection.CourseDepartmentProjection;
import com.carpi.carpibackend.projection.CourseSemesterProjection;
import com.carpi.carpibackend.repository.CourseAttributeRepository;
import com.carpi.carpibackend.repository.CourseRepository;
import com.carpi.carpibackend.repository.CourseSeatsRepository;
import com.carpi.carpibackend.service.CourseSearchService;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseSearchService courseSearchService;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseAttributeRepository courseAttributeRepository;

    @Autowired
    private CourseSeatsRepository courseSeatsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/all")
    @Operation(summary = "Gets a list of all courses.")
    public ResponseEntity<List<CourseDto>> getAll() {
        return searchCourses(null, null, null, null);
    }

    @GetMapping("/search")
    @Operation(summary = "Gets a list of courses based on an optional search prompt and optional filters.")
    public ResponseEntity<List<CourseDto>> searchCourses(
            @RequestParam(required = false) String searchPrompt,
            @RequestParam(required = false) String[] deptFilters,
            @RequestParam(required = false) String[] attrFilters,
            @RequestParam(required = false) String[] semFilters
    ) {
        List<CourseSearchResult> searchResults = courseSearchService.searchCourses(
                searchPrompt,
                deptFilters,
                attrFilters,
                semFilters
        );
        List<CourseDto> courseDtos = searchResults.stream().map(
                                        result -> modelMapper.map(result, CourseDto.class)
                                    ).collect(Collectors.toList());
        return ResponseEntity.ok(courseDtos);
    }

    @GetMapping("/filter/values/departments")
    @Operation(summary = "Gets a list of all departments.")
    public ResponseEntity<List<String>> getDepartments() {
        List<CourseDepartmentProjection> depts = courseRepository.getDistinctDepartments();
        List<String> deptNames = depts.stream().map(
                                    CourseDepartmentProjection::getDepartment
                                ).collect(Collectors.toList());
        return ResponseEntity.ok(deptNames);
    }

    @GetMapping("/filter/values/attributes")
    @Operation(summary = "Gets a list of all attributes.")
    public ResponseEntity<List<String>> getAttributes() {
        List<CourseAttributeProjection> depts = courseAttributeRepository.getDistinctAttributes();
        List<String> attrNames = depts.stream().map(
                                    CourseAttributeProjection::getAttribute
                                ).collect(Collectors.toList());
        return ResponseEntity.ok(attrNames);
    }

    @GetMapping("/filter/values/semesters")
    @Operation(summary = "Gets a list of all semesters.")
    public ResponseEntity<List<String>> getSemesters() {
        List<CourseSemesterProjection> depts = courseSeatsRepository.getDistinctSemesters();
        List<String> semNames = depts.stream().map(
                                    CourseSemesterProjection::getSemester
                                ).collect(Collectors.toList());
        return ResponseEntity.ok(semNames);
    }

}
