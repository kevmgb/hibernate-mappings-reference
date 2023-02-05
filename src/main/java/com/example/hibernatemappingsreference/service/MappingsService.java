package com.example.hibernatemappingsreference.service;

import com.example.hibernatemappingsreference.model.request.InstructorModelRequest;
import com.example.hibernatemappingsreference.model.response.InstructorDetailModelResponse;
import com.example.hibernatemappingsreference.model.response.InstructorModelResponse;

public interface MappingsService {
    void saveInstructor(InstructorModelRequest instructorModelRequest);

    InstructorModelResponse getInstructor(String id);

    InstructorModelRequest getInstructorDetail(String id);
}
