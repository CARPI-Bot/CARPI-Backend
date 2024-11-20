package com.carpi.carpibackend.keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CourseSeatsKey implements Serializable {
    
    @Column(name = "sem_year", insertable = false, updatable = false, nullable = false)
    private int semesterYear;

    @Column(name = "semester", insertable = false, updatable = false, nullable = false)
    private String semester;

    @Column(name = "dept", insertable = false, updatable = false, nullable = false)
    private String department;

    @Column(name = "code_num", insertable = false, updatable = false, nullable = false)
    private int code;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CourseSeatsKey) {
            CourseSeatsKey other = (CourseSeatsKey) obj;
            return semesterYear == other.semesterYear
                   && semester.equals(other.semester)
                   && department.equals(other.department)
                   && code == other.code;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(semesterYear);
        result = 31 * result + (semester != null ? semester.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + Integer.hashCode(code);
        return result;
    }
}