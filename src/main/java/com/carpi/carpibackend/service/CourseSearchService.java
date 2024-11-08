package com.carpi.carpibackend.service;

import java.util.Arrays;
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
     * @param deptFilters  Department filters (e.g. "CSCI", "MATH"). May be null.
     * @param attrFilters  Attribute filters (e.g. "HASS Inquiry"). May be null.
     * @param semFilters   Semester filters (e.g. "Fall", "Spring"). May be null.
     * @return A list containing the most relevant courses according to the given
     *         search prompt and filters, or a list of all courses if all arguments
     *         are null.
     */
    public List<CourseSearchResult> searchCourses(
            String searchPrompt,
            String[] deptFilters,
            String[] attrFilters,
            String[] semFilters
    ) {
        String[] deptFiltersCopy = null,
                 attrFiltersCopy = null,
                 semFiltersCopy = null;
        String deptFilterRegex = ".*",
               attrFilterRegex = ".*",
               semFilterRegex = ".*";
        if (deptFilters != null && deptFilters.length > 0) {
            deptFiltersCopy = Arrays.copyOf(deptFilters, deptFilters.length);
            Arrays.sort(deptFiltersCopy);
            deptFilterRegex = String.join("|", deptFiltersCopy);
        }
        if (attrFilters != null && attrFilters.length > 0) {
            attrFiltersCopy = Arrays.copyOf(attrFilters, attrFilters.length);
            Arrays.sort(attrFiltersCopy);
            attrFilterRegex = String.join(".*", attrFiltersCopy);
        }
        if (semFilters != null && semFilters.length > 0) {
            semFiltersCopy = Arrays.copyOf(semFilters, semFilters.length);
            Arrays.sort(semFiltersCopy);
            semFilterRegex = String.join(".*", semFiltersCopy);
        }
        if (searchPrompt == null) {
            return courseSearchResultRepository.searchCourses(
                ".*",
                ".*",
                ".*",
                ".*",
                ".*",
                ".*",
                deptFilterRegex,
                attrFilterRegex,
                semFilterRegex
            );
        }
        final String regStartOrSpace = "(^|.* )";
        String searchCodeRegex = "^" + searchPrompt + "$",
               searchFullRegex = "^" + searchPrompt + "$",
               searchStartRegex = "^" + searchPrompt,
               searchAnyRegex = searchPrompt,
               searchAcronymRegex = regStartOrSpace;
        for (int i = 0; i < searchPrompt.length(); ++i) {
            char ch = searchPrompt.charAt(i);
            if (ch != ' ') {
                searchAcronymRegex += ch + ".* ";
            }
        }
        searchAcronymRegex = searchAcronymRegex.substring(0, searchAcronymRegex.length() - 3);
        String searchAbbrevRegex = "";
        String[] tokens = searchPrompt.split(" ");
        if (tokens.length > 1) {
            searchAbbrevRegex += regStartOrSpace;
            for (int i = 0; i < tokens.length; ++i) {
                searchAbbrevRegex += tokens[i] + ".* ";
            }
            searchAbbrevRegex = searchAbbrevRegex.substring(0, searchAbbrevRegex.length() - 3);
        }
        else {
            searchAbbrevRegex = "a^";
        }
        return courseSearchResultRepository.searchCourses(
            searchCodeRegex,
            searchFullRegex,
            searchStartRegex,
            searchAnyRegex,
            searchAcronymRegex,
            searchAbbrevRegex,
            deptFilterRegex,
            attrFilterRegex,
            semFilterRegex
        );
    }
}
