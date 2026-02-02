package com.traineeMgt.repo;

import com.traineeMgt.entity.Trainee;
import com.traineeMgt.exception.TraineeDataAccessException;
import com.traineeMgt.exception.TraineeNotFoundException;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Profile("JDBC")
public class TraineeDaoJdbcImpl implements TraineeDao {

    private final JdbcTemplate jdbcTemplate;

    public TraineeDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Trainee> traineeRowMapper = (rs, rowNum) ->
    new Trainee(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("age"),
            rs.getInt("marks")
    );

    @Override
    @Transactional
    public void addTrainee(Trainee trainee) {
        try {
            String sql = "INSERT INTO trainee_table(name, age, marks) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, trainee.getName(), trainee.getAge(), trainee.getMarks());
        } catch (DataAccessException ex) {
            throw new TraineeDataAccessException(
                    "Failed to add trainee", ex);
        }
    }

    @Override
    public Trainee findById(int id) {
        try {
            String sql = "SELECT id, name, age, marks FROM trainee_table WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, traineeRowMapper, id);
        } catch (DataAccessException ex) {
            throw new TraineeNotFoundException(
                    "Failed to find trainee");
        }
    }
}
