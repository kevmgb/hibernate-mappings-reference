package com.example.hibernatemappingsreference.service.impl;

import com.example.hibernatemappingsreference.datalayer.entity.Instructor;
import com.example.hibernatemappingsreference.datalayer.entity.InstructorDetail;
import com.example.hibernatemappingsreference.datalayer.repository.InstructorRepository;
import com.example.hibernatemappingsreference.model.InstructorModel;
import com.example.hibernatemappingsreference.service.MappingsService;
import org.springframework.stereotype.Service;

@Service
public class MappingsServiceImpl implements MappingsService {
    private final InstructorRepository instructorRepository;

    public MappingsServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public void saveInstructor(InstructorModel instructorModel) {
        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setHobby(instructorModel.getInstructorDetail().getHobby());
        instructorDetail.setYoutubeChannel(instructorModel.getInstructorDetail().getYoutubeChannel());

        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorModel.getFirstName());
        instructor.setLastName(instructorModel.getLastName());
        instructor.setEmail(instructor.getEmail());
        instructor.setInstructorDetail(instructorDetail);

        instructorRepository.save(instructor);
    }
}
