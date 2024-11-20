package com.carpi.carpibackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carpi.carpibackend.entity.CourseSeats;
import com.carpi.carpibackend.keys.CourseSeatsKey;
import com.carpi.carpibackend.projection.CourseSemesterProjection;

public interface CourseSeatsRepository extends JpaRepository<CourseSeats, CourseSeatsKey> {

    @Query("SELECT DISTINCT c.semester AS semester FROM CourseSeats c")
    public List<CourseSemesterProjection> getDistinctSemesters();
}
