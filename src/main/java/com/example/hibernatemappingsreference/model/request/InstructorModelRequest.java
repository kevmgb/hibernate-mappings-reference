package com.example.hibernatemappingsreference.model.request;

import com.example.hibernatemappingsreference.datalayer.entity.Course;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class InstructorModelRequest {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("instructor_detail")
    private InstructorDetailModelRequest instructorDetail;

    @JsonProperty("instructor_courses")
    private List<Course> courseList;
}
