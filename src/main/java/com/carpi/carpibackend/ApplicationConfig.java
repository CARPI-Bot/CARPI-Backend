package com.carpi.carpibackend;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.carpi.carpibackend.dto.CourseDto;
import com.carpi.carpibackend.entity.CourseSearchResult;

@Configuration
public class ApplicationConfig {

    private static final String[] EMPTY_LIST = new String[0];
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        Converter<String, String[]> split =
                ctx -> ctx.getSource() == null ? EMPTY_LIST : ctx.getSource().split(",");
        modelMapper.typeMap(CourseSearchResult.class, CourseDto.class).addMappings(
            mapper -> {
                mapper.using(split).map(
                    CourseSearchResult::getSemesterList,
                    CourseDto::setSemesterList
                );
                mapper.using(split).map(
                    CourseSearchResult::getAttributeList,
                    CourseDto::setAttributeList
                );
            }
        );
        return modelMapper;
    }
}
