package com.carpi.carpibackend.keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class CourseKey implements Serializable {

    @Column(name = "dept", insertable = false, updatable = false, nullable = false)
    private String department;

    @Column(name = "code_num", insertable = false, updatable = false, nullable = false)
    private short code;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CourseKey) {
            CourseKey other = (CourseKey) obj;
            return (department != null ? department.equals(other.department) : other.department == null)
                   && code == other.code;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = (department != null ? department.hashCode() : 0);
        result = 31 * result + Integer.hashCode(code);
        return result;
    }
}
