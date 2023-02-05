package com.example.hibernatemappingsreference.controller;

import com.example.hibernatemappingsreference.datalayer.entity.Instructor;
import com.example.hibernatemappingsreference.datalayer.entity.InstructorDetail;
import com.example.hibernatemappingsreference.model.InstructorDetailModel;
import com.example.hibernatemappingsreference.model.InstructorModel;
import com.example.hibernatemappingsreference.service.MappingsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MappingsController {
    private final MappingsService service;

    public MappingsController(MappingsService service) {
        this.service = service;
    }

    @PostMapping("/createInstructor")
    private String createInstructor(@RequestBody @Validated InstructorModel instructorModel) {
        service.saveInstructor(instructorModel);
        return "Success";
    }

    @GetMapping("/getInstructor/{id}")
    private InstructorModel getInstructor(@PathVariable String id) {
        return service.getInstructor(id);
    }

    @GetMapping("/getInstructorDetail/{id}")
    private InstructorModel getInstructorDetail(@PathVariable String id) {
        return service.getInstructorDetail(id);
    }
}
