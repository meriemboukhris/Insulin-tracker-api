package com.project.insulintracker.services;

import com.project.insulintracker.exceptions.ItAuthException;
import com.project.insulintracker.domain.User;

public interface UserService {
    User validateUser (String email, String password) throws ItAuthException;
    User registerUser (String firstName, String lastName, String email, String password, String gender, String age, String height, String weight) throws ItAuthException;
}
