package com.carpi.carpibackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CourseDto {

    @NotBlank
    private String department;

    @Min(0)
    private short code;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @Min(0)
    private byte creditMin;

    @Min(0)
    private byte creditMax;

    @NotNull
    private String[] semesterList;
    
    @NotNull
    private String[] attributeList;
}
