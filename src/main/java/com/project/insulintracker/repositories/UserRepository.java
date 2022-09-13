package com.project.insulintracker.repositories;

import com.project.insulintracker.domain.User;
import com.project.insulintracker.exceptions.ItAuthException;

public interface UserRepository {
    Integer create (String firstName, String lastName, String email, String password, String gender, String age, String height, String weight) throws ItAuthException;
    User findByEmailAndPassword (String email, String password) throws ItAuthException;
    Integer getCountByEmail (String email);
    User findById (Integer userId);
}
