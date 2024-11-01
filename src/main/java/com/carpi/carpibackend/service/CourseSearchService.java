package com.carpi.carpibackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpi.carpibackend.entity.CourseSearchResult;
import com.carpi.carpibackend.repository.CourseSearchResultRepository;

@Service
public class CourseSearchService {
    
    @Autowired
    private CourseSearchResultRepository courseSearchResultRepository;

    /**
     * @author Jack Zgombic
     * @author Raymond Chen
     * @param searchPrompt Prompt used to search for relevant courses. May be null.
     * @param deptFilter Department filter (e.g. "CSCI", "MATH"). May be null.
     * @param attrFilter Attribute filter (e.g. "HASS Inquiry"). May be null.
     * @param semsFilter Semester filter (e.g. "Fall", "Spring"). May be null.
     * @return A list containing the most relevant courses according to the given
     *         search prompt and filters, or a list of all courses if all arguments
     *         are null.
     */
    public List<CourseSearchResult> searchCourses(
            String searchPrompt,
            String deptFilter,
            String attrFilter,
            String semsFilter
    ) {
        if (searchPrompt == null) {
            return courseSearchResultRepository.searchCourses(
                ".*",
                ".*",
                ".*",
                ".*",
                ".*",
                ".*",
                deptFilter,
                // attrFilter,
                semsFilter
            );
        }
        final String regStartOrSpace = "(^|.* )";
        String regexCode = "^" + searchPrompt + "$",
               regexFull = "^" + searchPrompt + "$",
               regexStart = "^" + searchPrompt,
               regexAny = searchPrompt,
               regexAcronym = regStartOrSpace;
        for (int i = 0; i < searchPrompt.length(); ++i) {
            char ch = searchPrompt.charAt(i);
            if (ch != ' ') {
                regexAcronym += ch + ".* ";
            }
        }
        regexAcronym = regexAcronym.substring(0, regexAcronym.length() - 3);
        String regexAbbrev = "";
        String[] tokens = searchPrompt.split(" ");
        if (tokens.length > 1) {
            regexAbbrev += regStartOrSpace;
            for (int i = 0; i < tokens.length; ++i) {
                regexAbbrev += tokens[i] + ".* ";
            }
            regexAbbrev = regexAbbrev.substring(0, regexAbbrev.length() - 3);
        }
        else {
            regexAbbrev = "a^";
        }
        return courseSearchResultRepository.searchCourses(
            regexCode,
            regexFull,
            regexStart,
            regexAny,
            regexAcronym,
            regexAbbrev,
            deptFilter,
            // attrFilter,
            semsFilter
        );
    }

}
