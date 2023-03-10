package com.example.hibernatemappingsreference.datalayer.repository;

import com.example.hibernatemappingsreference.datalayer.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    @Override
    Optional<Instructor> findById(Integer integer);
}
