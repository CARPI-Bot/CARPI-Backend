package com.carpi.carpibackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carpi.carpibackend.entity.CourseAttribute;
import com.carpi.carpibackend.keys.CourseAttributeKey;
import com.carpi.carpibackend.projection.CourseAttributeProjection;

public interface CourseAttributeRepository extends JpaRepository<CourseAttribute, CourseAttributeKey> {
    
    @Query("SELECT DISTINCT c.attribute AS attribute FROM CourseAttribute c")
    List<CourseAttributeProjection> getDistinctAttributes();
}
