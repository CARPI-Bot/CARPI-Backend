package com.carpi.carpibackend.entity;

import com.carpi.carpibackend.keys.CourseKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class CourseSearchResult {

    @EmbeddedId
    private CourseKey coursePk;

    @Column(name = "dept", nullable = false)
    private String department;

    @Column(name = "code_num", nullable = false)
    private short code;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "desc_text", nullable = false)
    private String description;

    @Column(name = "credit_min", nullable = false)
    private byte creditMin;

    @Column(name = "credit_max", nullable = false)
    private byte creditMax;

    @Column(name = "sem_list", nullable = false)
    private String semesterList;

    @Column(name = "attr_list", nullable = true)
    private String attributeList;

    @Column(name = "code_match", nullable = false)
    private boolean codeMatch;

    @Column(name = "title_exact_match", nullable = false)
    private boolean titleExactMatch;

    @Column(name = "title_start_match", nullable = false)
    private boolean titleStartMatch;

    @Column(name = "title_match", nullable = false)
    private boolean titleMatch;

    @Column(name = "title_acronym", nullable = false)
    private boolean titleAcronym;

    @Column(name = "title_abbrev", nullable = false)
    private boolean titleAbbrev;
}
