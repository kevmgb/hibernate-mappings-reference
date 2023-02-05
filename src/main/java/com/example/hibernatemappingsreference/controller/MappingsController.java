package com.example.hibernatemappingsreference.controller;

import com.example.hibernatemappingsreference.model.request.InstructorModelRequest;
import com.example.hibernatemappingsreference.model.response.InstructorDetailModelResponse;
import com.example.hibernatemappingsreference.model.response.InstructorModelResponse;
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
    private String createInstructor(@RequestBody @Validated InstructorModelRequest instructorModelRequest) {
        service.saveInstructor(instructorModelRequest);
        return "Success";
    }

    @GetMapping("/getInstructor/{id}")
    private InstructorModelResponse getInstructor(@PathVariable String id) {
        return service.getInstructor(id);
    }

    @GetMapping("/getInstructorDetail/{id}")
    private InstructorModelRequest getInstructorDetail(@PathVariable String id) {
        return service.getInstructorDetail(id);
    }
}
