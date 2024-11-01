package com.carpi.carpibackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carpi.carpibackend.entity.CourseSearchResult;
import com.carpi.carpibackend.keys.CourseKey;

@Repository
public interface CourseSearchResultRepository extends JpaRepository<CourseSearchResult, CourseKey> {
   
    @Query(
        value = """
            SELECT
                course.dept AS dept,
                course.code_num AS code_num,
                course.title AS title,
                course.desc_text AS desc_text,
                course.credit_min AS credit_min,
                course.credit_max AS credit_max,
                REGEXP_LIKE(CONCAT(course.dept, ' ', course.code_num), ?1, 'i') AS code_match,
                REGEXP_LIKE(course.title, ?2, 'i') AS title_exact_match,
                REGEXP_LIKE(course.title, ?3, 'i') AS title_start_match,
                REGEXP_LIKE(course.title, ?4, 'i') AS title_match,
                REGEXP_LIKE(course.title, ?5, 'i') AS title_acronym,
                REGEXP_LIKE(course.title, ?6, 'i') AS title_abbrev
            FROM
                course
            GROUP BY
                1, 2
            HAVING
                code_match > 0
                OR title_exact_match > 0
                OR title_start_match > 0
                OR title_match > 0
                OR title_acronym > 0
                OR title_abbrev > 0
            ORDER BY
                code_match DESC,
                title_exact_match DESC,
                title_start_match DESC,
                title_match DESC,
                title_acronym DESC,
                title_abbrev DESC,
                code_num ASC,
                dept ASC
            ;
        """,
        nativeQuery = true
    )
    public List<CourseSearchResult> searchCourse(
        String regexCode,
        String regexFull,
        String regexStart,
        String regexAny,
        String regexAcronym,
        String regexAbbrev
    );
}