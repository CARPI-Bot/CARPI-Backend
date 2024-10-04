package com.carpi.carpibackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpi.carpibackend.keys.CourseKey;
import com.carpi.carpibackend.entity.Course;

public interface CourseRepository extends JpaRepository<Course, CourseKey> {

}
