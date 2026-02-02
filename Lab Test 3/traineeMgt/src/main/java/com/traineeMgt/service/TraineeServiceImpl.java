package com.traineeMgt.service;

import org.springframework.stereotype.Service;

import com.traineeMgt.entity.Trainee;
import com.traineeMgt.repo.TraineeDao;
import com.traineeMgt.exception.TraineeNotFoundException;
import com.traineeMgt.exception.TraineeDataAccessException;

@Service
public class TraineeServiceImpl implements TraineeService {

    private final TraineeDao traineeDao;

    public TraineeServiceImpl(TraineeDao traineeDao) {
        this.traineeDao = traineeDao;
    }

 
    @Override
    public void addTrainee(Trainee trainee) {
        try {
            traineeDao.addTrainee(trainee);
        } catch (Exception e) {
            throw new TraineeDataAccessException("Failed to add trainee", e);
        }
    }

 
    @Override
    public Trainee findById(int id) {
        try {
            Trainee trainee = traineeDao.findById(id);
            if (trainee == null) {
                throw new TraineeNotFoundException("Trainee not found with id: " + id);
            }
            return trainee;
        } catch (TraineeNotFoundException e) {
            throw e;
        }
    }
}
