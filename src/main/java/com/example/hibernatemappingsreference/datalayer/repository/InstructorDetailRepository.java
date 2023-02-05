package com.example.hibernatemappingsreference.datalayer.repository;

import com.example.hibernatemappingsreference.datalayer.entity.Instructor;
import com.example.hibernatemappingsreference.datalayer.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {
    @Override
    Optional<InstructorDetail> findById(Integer integer);
}
