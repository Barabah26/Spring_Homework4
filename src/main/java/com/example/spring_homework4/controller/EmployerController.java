package com.example.spring_homework4.controller;

import com.example.spring_homework4.dto.employer.EmployerDtoResponse;
import com.example.spring_homework4.mapper.employer.EmployerDtoMapperResponse;
import com.example.spring_homework4.service.DefaultEmployerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
public class EmployerController {

    private final DefaultEmployerService employerService;
    private final EmployerDtoMapperResponse employerDtoMapperResponse;

    @Operation(summary = "Get all employers")
    @GetMapping
    public List<EmployerDtoResponse> getAll() {
        return employerService.findAll().stream().map(employerDtoMapperResponse::convertToDto).toList();
    }


}
