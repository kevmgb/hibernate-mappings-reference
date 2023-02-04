package com.example.hibernatemappingsreference.controller;

import com.example.hibernatemappingsreference.model.InstructorModel;
import com.example.hibernatemappingsreference.service.MappingsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
