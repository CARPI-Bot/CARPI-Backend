package com.carpi.carpibackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpi.carpibackend.entity.Department;
import com.carpi.carpibackend.keys.DepartmentKey;

public interface DepartmentRepository extends JpaRepository<Department, DepartmentKey> {

}
