package com.carpi.carpibackend.entity;

import com.carpi.carpibackend.keys.CourseKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "course")
public class Course {

    @EmbeddedId
    private CourseKey pkCourses;

    @Column(name = "dept", nullable = false)
    private String department;

    @Column(name = "code_num", nullable = false)
    private int code;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "desc_text", nullable = false)
    private String description;

    @Column(name = "credit_min", nullable = false)
    private short creditMin;

    @Column(name = "credit_max", nullable = false)
    private short creditMax;
}
