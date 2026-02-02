package com.traineeMgt.service;

import com.traineeMgt.entity.Trainee;

public interface TraineeService {
    void addTrainee(Trainee trainee);
    Trainee findById(int id);
}
