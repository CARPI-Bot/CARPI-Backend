package com.carpi.carpibackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CourseDto {

    private String department;

    private int code;

    private String title;

    private String description;

    private short creditMin;

    private short creditMax;
}
