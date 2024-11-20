package com.carpi.carpibackend.entity;

import com.carpi.carpibackend.keys.CourseAttributeKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "course_attribute")
public class CourseAttribute {
    
    @EmbeddedId
    private CourseAttributeKey courseAttributePk;

    @Column(name = "dept", nullable = false)
    private String department;

    @Column(name = "code_num", nullable = false)
    private short code;

    @Column(name = "attr", nullable = false)
    private String attribute;
}
