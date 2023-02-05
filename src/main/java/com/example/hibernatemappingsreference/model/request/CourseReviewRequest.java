package com.example.hibernatemappingsreference.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseReviewRequest {
    @JsonProperty("id")
    private String id;

    @JsonProperty("review")
    private String review;

    public CourseReviewRequest(String id, String review) {
        this.id = id;
        this.review = review;
    }
}
