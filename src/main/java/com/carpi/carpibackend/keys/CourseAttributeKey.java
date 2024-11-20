package com.carpi.carpibackend.keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CourseAttributeKey implements Serializable {
    
    @Column(name = "dept", insertable = false, updatable = false, nullable = false)
    private String department;

    @Column(name = "code_num", insertable = false, updatable = false, nullable = false)
    private int code;

    @Column(name = "attr", insertable = false, updatable = false, nullable = false)
    private String attr;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CourseAttributeKey) {
            CourseAttributeKey other = (CourseAttributeKey) obj;
            return department.equals(other.department)
                   && code == other.code
                   && attr.equals(other.attr);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = department != null ? department.hashCode() : 0;
        result = 31 * result + Integer.hashCode(code);
        result = 31 * result + attr != null ? attr.hashCode() : 0;
        return result;
    }

}
