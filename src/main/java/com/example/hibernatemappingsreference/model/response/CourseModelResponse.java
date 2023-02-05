package com.example.hibernatemappingsreference.model.response;

import com.example.hibernatemappingsreference.datalayer.entity.Review;
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
public class CourseModelResponse {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("reviews")
    private List<Review> reviewList;

}
