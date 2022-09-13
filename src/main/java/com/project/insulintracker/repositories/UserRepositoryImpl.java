package com.project.insulintracker.repositories;


import com.project.insulintracker.domain.User;
import com.project.insulintracker.exceptions.ItAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private static final String SQL_CREATE = "INSERT INTO users_ins(user_id, first_name, last_name, email, password, gender, age, height, weight VALUES(NEXTVAL('users_ins_seq'), ?, ?, ?, ?, ? , ?, ?, ?)";
    private static final String SQL_COUNT_BY_EMAIL= "SELECT COUNT(*) FROM users_ins WHERE EMAIL= ?";
    private static final String SQL_FIND_BY_ID="SELECT user_id, first_name, last_name, email, password, gender, age, height, weight FROM users_ins where user_id= ?";
    private static final String SQL_FIND_BY_EMAIL="SELECT user_id, first_name, last_name, email, password, gender, age, height, weight FROM users_ins where email= ?";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String firstName, String lastName, String email, String password, String gender, String age, String height, String weight) throws ItAuthException {
        String hashedPassword= BCrypt.hashpw(password, BCrypt.gensalt(10));

        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.setString(3, email);
                ps.setString(4, password);
                ps.setString(5, gender);
                ps.setString(6, age);
                ps.setString(7, height);
                ps.setString(8, weight);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("user_id");
        }
        catch(Exception e){
            throw new ItAuthException("Invalid details. Failed to create account");
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws ItAuthException {
        try {
            User user = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, new Object[]{email}, userRowMapper);
            if (!BCrypt.checkpw(password, user.getPassword()))
                throw new ItAuthException("Invalid email or password");
                return user;
        }
        catch (EmptyResultDataAccessException e){
            throw new ItAuthException("Invalid email or password");
        }

    }

    @Override
    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object[]{email}, Integer.class);
    }

    @Override
    public User findById(Integer userId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId}, userRowMapper);
    }

    private RowMapper<User> userRowMapper = ((rs, rowNum) -> {
        return new User(rs.getInt("user_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("gender"),
                rs.getString("age"),
                rs.getString("height"),
                rs.getString("weight"));
    });
}
