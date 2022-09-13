package com.project.insulintracker.repositories;

import com.project.insulintracker.domain.BloodGlucoseLevels;
import com.project.insulintracker.exceptions.ItBadRequestException;
import com.project.insulintracker.exceptions.ItResourceNotFoundException;

import java.util.List;

public interface BloodGlucoseLevelsRepository {
    List<BloodGlucoseLevels> findAll(Integer userId) throws ItResourceNotFoundException;
    BloodGlucoseLevels findById(Integer userId, Integer index) throws ItResourceNotFoundException;
    Integer create(Integer userId, String bG_before_breakfast, String bG_2h_after_breakfast, String bG_before_lunch, String bG_2h_after_lunch, String bG_before_dinner, String bG_2h_after_dinner, String notes) throws ItBadRequestException;
    void update (Integer userId, Integer index, BloodGlucoseLevels bloodGlucoseLevels) throws ItBadRequestException;
    void removeById(Integer userId, Integer index);
}
