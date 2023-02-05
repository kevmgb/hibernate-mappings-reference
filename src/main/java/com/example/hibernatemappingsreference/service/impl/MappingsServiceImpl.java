package com.example.hibernatemappingsreference.service.impl;

import com.example.hibernatemappingsreference.datalayer.entity.Instructor;
import com.example.hibernatemappingsreference.datalayer.entity.InstructorDetail;
import com.example.hibernatemappingsreference.datalayer.repository.InstructorDetailRepository;
import com.example.hibernatemappingsreference.datalayer.repository.InstructorRepository;
import com.example.hibernatemappingsreference.model.InstructorDetailModel;
import com.example.hibernatemappingsreference.model.InstructorModel;
import com.example.hibernatemappingsreference.service.MappingsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingsServiceImpl implements MappingsService {
    private final InstructorRepository instructorRepository;
    private final InstructorDetailRepository instructorDetailRepository;

    public MappingsServiceImpl(InstructorRepository instructorRepository, InstructorDetailRepository instructorDetailRepository) {
        this.instructorRepository = instructorRepository;
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @Override
    public void saveInstructor(InstructorModel instructorModel) {
        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setHobby(instructorModel.getInstructorDetail().getHobby());
        instructorDetail.setYoutubeChannel(instructorModel.getInstructorDetail().getYoutubeChannel());

        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorModel.getFirstName());
        instructor.setLastName(instructorModel.getLastName());
        instructor.setEmail(instructorModel.getEmail());
        instructor.setInstructorDetail(instructorDetail);

        instructorRepository.save(instructor);
    }

    @Override
    public InstructorModel getInstructor(String id) {
        Optional<Instructor> instructor = instructorRepository.findById(Integer.valueOf(id));

        if (instructor.isPresent()) {
            InstructorDetailModel instructorDetailModel = new InstructorDetailModel();
            instructorDetailModel.setHobby(instructor.get().getInstructorDetail().getHobby());
            instructorDetailModel.setYoutubeChannel(instructor.get().getInstructorDetail().getYoutubeChannel());

            InstructorModel instructorModel = new InstructorModel();
            instructorModel.setFirstName(instructor.get().getFirstName());
            instructorModel.setLastName(instructor.get().getLastName());
            instructorModel.setEmail(instructor.get().getEmail());
            instructorModel.setInstructorDetail(instructorDetailModel);

            return instructorModel;
        }
        return null;
    }

    @Override
    public InstructorModel getInstructorDetail(String id) {
        Optional<InstructorDetail> instructorDetail = instructorDetailRepository.findById(Integer.valueOf(id));

        if (instructorDetail.isPresent()) {
            InstructorDetailModel instructorDetailModel = new InstructorDetailModel();
            instructorDetailModel.setHobby(instructorDetail.get().getHobby());
            instructorDetailModel.setYoutubeChannel(instructorDetail.get().getYoutubeChannel());

            InstructorModel instructorModel = new InstructorModel();
            instructorModel.setFirstName(instructorDetail.get().getInstructor().getFirstName());
            instructorModel.setLastName(instructorDetail.get().getInstructor().getLastName());
            instructorModel.setEmail(instructorDetail.get().getInstructor().getEmail());
            instructorModel.setInstructorDetail(instructorDetailModel);

            return instructorModel;
        }
        return null;
    }
}
