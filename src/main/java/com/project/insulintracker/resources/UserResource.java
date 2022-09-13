package com.project.insulintracker.resources;

import com.project.insulintracker.Constants;
import com.project.insulintracker.domain.User;
import com.project.insulintracker.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap){
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.validateUser(email, password);

        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }


    @PostMapping("/register")

    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap ){
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        String gender = (String) userMap.get("gender");
        String age = (String) userMap.get("age");
        String height = (String) userMap.get("height");
        String weight = (String) userMap.get("weight");
        User user =userService.registerUser(firstName, lastName, email, password, gender, age, height, weight);
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }
    private Map<String, String> generateJWTToken(User user){
        long timestamp= System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.ES256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("userId", user.getUserId())
                .claim("email", user.getEmail())
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .claim("gender", user.getGender())
                .claim("age", user.getAge())
                .claim("height", user.getHeight())
                .claim("weight", user.getWeight())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;

    }


}
