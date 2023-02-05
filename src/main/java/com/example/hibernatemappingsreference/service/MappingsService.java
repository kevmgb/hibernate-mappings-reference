package com.example.hibernatemappingsreference.service;

import com.example.hibernatemappingsreference.datalayer.entity.Instructor;
import com.example.hibernatemappingsreference.datalayer.entity.InstructorDetail;
import com.example.hibernatemappingsreference.model.InstructorModel;

public interface MappingsService {
    void saveInstructor(InstructorModel instructorModel);

    InstructorModel getInstructor(String id);

    InstructorModel getInstructorDetail(String id);
}
