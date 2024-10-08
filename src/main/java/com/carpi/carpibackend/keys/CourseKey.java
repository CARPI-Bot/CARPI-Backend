package com.carpi.carpibackend.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class CourseKey implements Serializable {

    @Column(name = "dept", insertable = false, updatable = false, nullable = false)
    private String department;

    @Column(name = "code_num", insertable = false, updatable = false, nullable = false)
    private int code;

}
