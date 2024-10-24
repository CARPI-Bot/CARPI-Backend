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
     * 
     * @param searchTerm
     * @return
     */
    public List<CourseSearchResult> searchCourse(String searchTerm) {
        final String regStartOrSpace = "(^|.* )";
        String regexCode = "^" + searchTerm + "$",
               regexFull = "^" + searchTerm + "$",
               regexStart = "^" + searchTerm,
               regexAny = searchTerm,
               regexAcronym = regStartOrSpace;
        for (int i = 0; i < searchTerm.length(); ++i) {
            char ch = searchTerm.charAt(i);
            if (ch != ' ') {
                regexAcronym += ch + ".* ";
            }
        }
        regexAcronym = regexAcronym.substring(0, regexAcronym.length() - 3);
        String regexAbbrev = "";
        String[] tokens = searchTerm.split(" ");
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
        return courseSearchResultRepository.searchCourse(
            regexCode,
            regexFull,
            regexStart,
            regexAny,
            regexAcronym,
            regexAbbrev
        );
    }

}
