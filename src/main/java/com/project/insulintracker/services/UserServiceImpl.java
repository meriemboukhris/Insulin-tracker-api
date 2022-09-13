package com.project.insulintracker.services;

import com.project.insulintracker.domain.User;
import com.project.insulintracker.exceptions.ItAuthException;
import com.project.insulintracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;
import java.util.Locale;
import java.util.regex.Pattern;

@Service
@Transactional
 public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser (String email, String password) throws ItAuthException{
        if (email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser (String firstName, String lastName, String email, String password, String gender, String age, String height, String weight) throws ItAuthException{
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email!=null) email= email.toLowerCase();
        if (!pattern.matcher(email).matches())
            throw new ItAuthException("Invalid email format");
        Integer count = userRepository.getCountByEmail(email);
        if (count>0)
            throw new ItAuthException("Email already in use");
        Integer userId= userRepository.create( firstName,  lastName,  email,  password,  gender,  age,  height, weight);
        return userRepository.findById(userId);
}
}
