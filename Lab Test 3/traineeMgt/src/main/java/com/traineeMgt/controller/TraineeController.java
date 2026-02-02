package com.traineeMgt.controller;

import org.springframework.web.bind.annotation.*;

import com.traineeMgt.entity.Trainee;
import com.traineeMgt.service.TraineeService;

@RestController
@RequestMapping("/trainee")
public class TraineeController {

    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }
    @PostMapping
    public Trainee addTrainee(@RequestBody Trainee trainee) {
        traineeService.addTrainee(trainee);
        return trainee;
    }
  
    @GetMapping("/{id}")
    public Trainee getTraineeById(@PathVariable int id) {
        return traineeService.findById(id);
    }
}


























