package com.carpi.carpibackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carpi.carpibackend.entity.Course;
import com.carpi.carpibackend.keys.CourseKey;

@Repository
public interface CourseRepository extends JpaRepository<Course, CourseKey> {

}
