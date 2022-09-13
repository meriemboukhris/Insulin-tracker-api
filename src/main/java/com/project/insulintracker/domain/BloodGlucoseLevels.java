package com.project.insulintracker.domain;

public class BloodGlucoseLevels {
    private Integer index;
    private Integer userId;
    private String bG_before_breakfast;
    private String bG_2h_after_breakfast;
    private String bG_before_lunch;
    private String bG_2h_after_lunch;
    private String bG_before_dinner;
    private String bG_2h_after_dinner;
    private String Notes;

    public BloodGlucoseLevels(Integer index, Integer userId, String bG_before_breakfast, String bG_2h_after_breakfast, String bG_before_lunch, String bG_2h_after_lunch, String bG_before_dinner, String bG_2h_after_dinner, String notes) {
        this.index = index;
        this.userId = userId;
        this.bG_before_breakfast = bG_before_breakfast;
        this.bG_2h_after_breakfast = bG_2h_after_breakfast;
        this.bG_before_lunch = bG_before_lunch;
        this.bG_2h_after_lunch = bG_2h_after_lunch;
        this.bG_before_dinner = bG_before_dinner;
        this.bG_2h_after_dinner = bG_2h_after_dinner;
        Notes = notes;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getbG_before_breakfast() {
        return bG_before_breakfast;
    }

    public void setbG_before_breakfast(String bG_before_breakfast) {
        this.bG_before_breakfast = bG_before_breakfast;
    }

    public String getbG_2h_after_breakfast() {
        return bG_2h_after_breakfast;
    }

    public void setbG_2h_after_breakfast(String bG_2h_after_breakfast) {
        this.bG_2h_after_breakfast = bG_2h_after_breakfast;
    }

    public String getbG_before_lunch() {
        return bG_before_lunch;
    }

    public void setbG_before_lunch(String bG_before_lunch) {
        this.bG_before_lunch = bG_before_lunch;
    }

    public String getbG_2h_after_lunch() {
        return bG_2h_after_lunch;
    }

    public void setbG_2h_after_lunch(String bG_2h_after_lunch) {
        this.bG_2h_after_lunch = bG_2h_after_lunch;
    }

    public String getbG_before_dinner() {
        return bG_before_dinner;
    }

    public void setbG_before_dinner(String bG_before_dinner) {
        this.bG_before_dinner = bG_before_dinner;
    }

    public String getbG_2h_after_dinner() {
        return bG_2h_after_dinner;
    }

    public void setbG_2h_after_dinner(String bG_2h_after_dinner) {
        this.bG_2h_after_dinner = bG_2h_after_dinner;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
