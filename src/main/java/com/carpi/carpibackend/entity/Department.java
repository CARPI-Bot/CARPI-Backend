package com.carpi.carpibackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.carpi.carpibackend.keys.DepartmentKey;

@Getter
@Setter

@Entity
@Table(name = "departments")
public class Department {

    @EmbeddedId
    private DepartmentKey pkDepartments;

    @Column(name = "dept_code", nullable = false)
    private String departmentCode;

    @Column(name = "dept_name", nullable = false)
    private String departmentName;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

}
