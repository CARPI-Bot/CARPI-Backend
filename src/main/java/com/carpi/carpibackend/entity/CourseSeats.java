package com.carpi.carpibackend.entity;

import com.carpi.carpibackend.keys.CourseSeatsKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_seats")
public class CourseSeats {
    
    @EmbeddedId
    private CourseSeatsKey courseSeatsPk;

    @Column(name = "sem_year", nullable = false)
    private short semesterYear;

    @Column(name = "semester", nullable = false)
    private String semester;

    @Column(name = "dept", nullable = false)
    private String department;

    @Column(name = "code_num", nullable = false)
    private short code;

    @Column(name = "seats_filled", nullable = false)
    private short seatsFilled;

    @Column(name = "seats_total", nullable = false)
    private short seatsTotal;
}
