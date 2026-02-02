package com.traineeMgt.repo;

import com.traineeMgt.entity.Trainee;

public interface TraineeDao {
    void addTrainee(Trainee trainee);
    Trainee findById(int id);
}
