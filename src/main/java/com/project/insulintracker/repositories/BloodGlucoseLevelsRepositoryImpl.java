package com.project.insulintracker.repositories;

import com.project.insulintracker.domain.BloodGlucoseLevels;
import com.project.insulintracker.exceptions.ItBadRequestException;
import com.project.insulintracker.exceptions.ItResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class BloodGlucoseLevelsRepositoryImpl implements BloodGlucoseLevelsRepository {
    private static final String SQL_FIND_BY_ID="SELECT user_id, first_name, last_name, email, password, gender, age, height, weight FROM users_ins where user_id= ?";
    private static final String SQL_CREATE = "INSERT INTO blood_glucose_levels( index, userId, bG_before_breakfast, bG_2h_after_breakfast, bG_before_lunch, bG_2h_after_lunch, bG_before_dinner, bG_2h_after_dinner,  notes) VALUES (NEXTVAL('blood_glucose_levels_seq'), ?, ?, ?, ?, ?, ?, ?, ?)";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<BloodGlucoseLevels> findAll(Integer userId) throws ItResourceNotFoundException {
        return null;
    }

    @Override
    public BloodGlucoseLevels findById(Integer userId, Integer index) throws ItResourceNotFoundException {
        return null;
    }

    @Override
    public Integer create(Integer userId, String bG_before_breakfast, String bG_2h_after_breakfast, String bG_before_lunch, String bG_2h_after_lunch, String bG_before_dinner, String bG_2h_after_dinner, String notes) throws ItBadRequestException {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userId);
                ps.setString(2, bG_before_breakfast);
                ps.setString(3, bG_2h_after_breakfast);
                ps.setString(4, bG_before_lunch);
                ps.setString(5, bG_2h_after_lunch);
                ps.setString(6, bG_before_dinner);
                ps.setString(7, bG_2h_after_dinner);
                ps.setString(8, notes);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("index");
        }
        catch (Exception e){
            throw new ItBadRequestException("Invalid Request");

        }
    }

    @Override
    public void update(Integer userId, Integer index, BloodGlucoseLevels bloodGlucoseLevels) throws ItBadRequestException {

    }

    @Override
    public void removeById(Integer userId, Integer index) {

    }
}
