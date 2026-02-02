package com.traineeMgt.repo;

import com.traineeMgt.entity.Trainee;
import com.traineeMgt.exception.TraineeDataAccessException;
import com.traineeMgt.exception.TraineeNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Profile("JPA")
public class TraineeDaoJpaImpl implements TraineeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addTrainee(Trainee trainee) {
        try {
            entityManager.persist(trainee);
        } catch (PersistenceException ex) {
            throw new TraineeDataAccessException(
                    "failed to add trainee ", ex);
        }
    }

    @Override
    public Trainee findById(int id) {
        try {
            return entityManager.find(Trainee.class, id);
        } catch (PersistenceException ex) {
            throw new TraineeNotFoundException(
                    "failed to find trainee ");
        }
    }
}
