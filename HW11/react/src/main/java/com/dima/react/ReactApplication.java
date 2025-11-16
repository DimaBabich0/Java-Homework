package com.dima.react;

import com.dima.react.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
public class ReactApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReactApplication.class, args);
    }
}

@RestController
@CrossOrigin(origins = "http://localhost:5173")
class UserController {
    private static final Map<String, User> users = new HashMap<>();
    private static final Map<String, String> tokens = new HashMap<>();

    @PostMapping("/api/login")
    public Map<String, Object> login(@RequestBody Map<String, String> data) {
    	System.out.println("Get POST-request for login:");
		data.forEach((key, value) -> System.out.println(key + ": " + value));

    	String login = data.get("login");
        String password = data.get("password");

        Map<String, Object> response = new HashMap<>();
        User user = users.get(login);

        if (user == null) {
            response.put("success", false);
            response.put("message", "Нема такого користувача.");
        } else if (!user.getPassword().equals(password)) {
            response.put("success", false);
            response.put("message", "Невірний пароль.");
        } else {
            String token = UUID.randomUUID().toString();
            tokens.put(token, login);
            response.put("success", true);
            response.put("token", token);
        }

        return response;
    }

    @PostMapping("/api/register")
    public Map<String, Object> register(@RequestBody Map<String, String> data) {
    	System.out.println("Get POST-request for register:");
		data.forEach((key, value) -> System.out.println(key + ": " + value));
		
        String login = data.get("login");
        String password = data.get("password");

        Map<String, Object> response = new HashMap<>();

        if (users.containsKey(login)) {
            response.put("success", false);
            response.put("message", "Такий користувач вже існує. Спробуйте інший логін.");
            System.out.println("User registration not successful: " + login);
        } else {
            users.put(login, new User(login, password));
            response.put("success", true);
            response.put("message", "Реєстрація успішна.");
            System.out.println("User registration successful: " + login);
        }

        return response;
    }

    @PostMapping("/api/verify-token")
    public Map<String, Object> verifyToken(@RequestBody Map<String, String> data) {
    	System.out.println("Get POST-request for token:");
		data.forEach((key, value) -> System.out.println(key + ": " + value));
		
        String token = data.get("token");

        Map<String, Object> response = new HashMap<>();
        if (tokens.containsKey(token)) {
            response.put("success", true);
            response.put("message", "Токен валідний.");
        	System.out.println("Token is valid");
        } else {
            response.put("success", false);
            response.put("message", "Невалідний токен.");
            System.out.println("Token is invalid");
        }

        return response;
    }
}
