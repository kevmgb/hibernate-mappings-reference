package com.example.hibernatemappingsreference.service.impl;

import com.example.hibernatemappingsreference.datalayer.entity.Course;
import com.example.hibernatemappingsreference.datalayer.entity.Instructor;
import com.example.hibernatemappingsreference.datalayer.entity.InstructorDetail;
import com.example.hibernatemappingsreference.datalayer.entity.Review;
import com.example.hibernatemappingsreference.datalayer.repository.CourseRepository;
import com.example.hibernatemappingsreference.datalayer.repository.InstructorDetailRepository;
import com.example.hibernatemappingsreference.datalayer.repository.InstructorRepository;
import com.example.hibernatemappingsreference.model.dto.CourseDto;
import com.example.hibernatemappingsreference.model.request.CourseReviewRequest;
import com.example.hibernatemappingsreference.model.request.InstructorDetailModelRequest;
import com.example.hibernatemappingsreference.model.request.InstructorModelRequest;
import com.example.hibernatemappingsreference.model.response.CourseModelResponse;
import com.example.hibernatemappingsreference.model.response.InstructorModelResponse;
import com.example.hibernatemappingsreference.service.MappingsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MappingsServiceImpl implements MappingsService {
    private final InstructorRepository instructorRepository;
    private final InstructorDetailRepository instructorDetailRepository;
    private final CourseRepository courseRepository;

    public MappingsServiceImpl(InstructorRepository instructorRepository,
                               InstructorDetailRepository instructorDetailRepository,
                               CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.instructorDetailRepository = instructorDetailRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void saveInstructor(InstructorModelRequest instructorModelRequest) {
        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setHobby(instructorModelRequest.getInstructorDetail().getHobby());
        instructorDetail.setYoutubeChannel(instructorModelRequest.getInstructorDetail().getYoutubeChannel());

        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorModelRequest.getFirstName());
        instructor.setLastName(instructorModelRequest.getLastName());
        instructor.setEmail(instructorModelRequest.getEmail());
        instructor.setInstructorDetail(instructorDetail);
        instructorModelRequest.getCourseList().forEach(s -> {
            instructor.add(s);
        });

        instructorRepository.save(instructor);
    }

    @Override
    public InstructorModelResponse getInstructor(String id) {
        Optional<Instructor> instructor = instructorRepository.findById(Integer.valueOf(id));

        if (instructor.isPresent()) {
            InstructorDetailModelRequest instructorDetailModelRequest = new InstructorDetailModelRequest();
            instructorDetailModelRequest.setHobby(instructor.get().getInstructorDetail().getHobby());
            instructorDetailModelRequest.setYoutubeChannel(instructor.get().getInstructorDetail().getYoutubeChannel());

            InstructorModelResponse instructorModelResponse = new InstructorModelResponse();
            instructorModelResponse.setFirstName(instructor.get().getFirstName());
            instructorModelResponse.setLastName(instructor.get().getLastName());
            instructorModelResponse.setEmail(instructor.get().getEmail());
            instructorModelResponse.setInstructorDetail(instructorDetailModelRequest);

            instructor.get().getCourseList().forEach(s -> {
                CourseDto courseDto = new CourseDto(s.getId(), s.getTitle());
                instructorModelResponse.getCourseList().add(courseDto);
            });

            return instructorModelResponse;
        }
        return null;
    }

    @Override
    public InstructorModelRequest getInstructorDetail(String id) {
        Optional<InstructorDetail> instructorDetail = instructorDetailRepository.findById(Integer.valueOf(id));

        if (instructorDetail.isPresent()) {
            InstructorDetailModelRequest instructorDetailModelRequest = new InstructorDetailModelRequest();
            instructorDetailModelRequest.setHobby(instructorDetail.get().getHobby());
            instructorDetailModelRequest.setYoutubeChannel(instructorDetail.get().getYoutubeChannel());

            InstructorModelRequest instructorModelRequest = new InstructorModelRequest();
            instructorModelRequest.setFirstName(instructorDetail.get().getInstructor().getFirstName());
            instructorModelRequest.setLastName(instructorDetail.get().getInstructor().getLastName());
            instructorModelRequest.setEmail(instructorDetail.get().getInstructor().getEmail());
            instructorModelRequest.setInstructorDetail(instructorDetailModelRequest);

            return instructorModelRequest;
        }
        return null;
    }

    @Override
    public String reviewCourse(CourseReviewRequest courseReviewRequest) {
        // Fetch course
        Optional<Course> course = courseRepository.findById(Integer.valueOf(courseReviewRequest.getId()));

        if (course.isPresent()) {
            Review review = new Review();
            review.setComment(courseReviewRequest.getReview());

            List<Review> reviews = course.get().getReviews();
            reviews.add(review);

            course.get().setReviews(reviews);

            courseRepository.save(course.get());
            return "Success";
        }else {
            return "Course not found!";
        }
    }

    @Override
    public CourseModelResponse getCourse(String id) {
        Optional<Course> course = courseRepository.findById(Integer.valueOf(id));

        if (course.isPresent()) {
            CourseModelResponse courseModelResponse = new CourseModelResponse();
            courseModelResponse.setId(course.get().getId());
            courseModelResponse.setTitle(course.get().getTitle());
            courseModelResponse.setReviewList(course.get().getReviews());

            return courseModelResponse;
        }
        return null;
    }
}
