package com.example.hibernatemappingsreference.service;

import com.example.hibernatemappingsreference.model.request.CourseReviewRequest;
import com.example.hibernatemappingsreference.model.request.InstructorModelRequest;
import com.example.hibernatemappingsreference.model.response.CourseModelResponse;
import com.example.hibernatemappingsreference.model.response.InstructorModelResponse;

public interface MappingsService {
    void saveInstructor(InstructorModelRequest instructorModelRequest);

    InstructorModelResponse getInstructor(String id);

    InstructorModelRequest getInstructorDetail(String id);

    String reviewCourse(CourseReviewRequest courseReviewRequest);

    CourseModelResponse getCourse(String id);
}
