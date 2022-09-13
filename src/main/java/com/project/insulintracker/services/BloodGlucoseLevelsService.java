package com.project.insulintracker.services;

import com.project.insulintracker.exceptions.ItResourceNotFoundException;
import com.project.insulintracker.exceptions.ItBadRequestException;
import com.project.insulintracker.domain.BloodGlucoseLevels;
import java.util.List;

public interface BloodGlucoseLevelsService {
    List <BloodGlucoseLevels> fetchAllBGLEntries(Integer userId);
    BloodGlucoseLevels fetchBGLById(Integer userId, Integer index) throws ItResourceNotFoundException;
    BloodGlucoseLevels addBGLEntry (Integer userId, String bG_before_breakfast, String bG_2h_after_breakfast, String bG_before_lunch, String bG_2h_after_lunch, String bG_before_dinner, String bG_2h_after_dinner, String notes) throws ItResourceNotFoundException;
    void updateBGLEntry(Integer userId, Integer index, BloodGlucoseLevels bloodGlucoseLevels) throws ItBadRequestException;

}
