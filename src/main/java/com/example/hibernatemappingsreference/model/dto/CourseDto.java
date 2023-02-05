package com.example.hibernatemappingsreference.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CourseDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;
}
