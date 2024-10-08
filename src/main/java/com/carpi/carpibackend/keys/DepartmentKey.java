package com.carpi.carpibackend.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class DepartmentKey implements Serializable {

    @Column(name = "dept_code", insertable = false, updatable = false, nullable = false)
    private String departmentCode;

}
