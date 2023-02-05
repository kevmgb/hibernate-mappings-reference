package com.example.hibernatemappingsreference.model.response;

import com.example.hibernatemappingsreference.model.dto.CourseDto;
import com.example.hibernatemappingsreference.model.request.InstructorDetailModelRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class InstructorModelResponse {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("instructor_detail")
    private InstructorDetailModelRequest instructorDetail;

    @JsonProperty("instructor_courses")
    private List<CourseDto> courseList = new ArrayList<>();
}
