package com.carpi.carpibackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carpi.carpibackend.entity.Course;
import com.carpi.carpibackend.keys.CourseKey;
import com.carpi.carpibackend.projection.CourseDepartmentProjection;

@Repository
public interface CourseRepository extends JpaRepository<Course, CourseKey> {

    @Query("SELECT DISTINCT c.department AS department FROM Course c")
    public List<CourseDepartmentProjection> getDistinctDepartments();
}
