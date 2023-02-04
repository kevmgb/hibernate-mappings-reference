package com.example.hibernatemappingsreference.datalayer.repository;

import com.example.hibernatemappingsreference.datalayer.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
