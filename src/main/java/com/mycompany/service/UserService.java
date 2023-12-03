package com.mycompany.service;

import com.mycompany.entity.User;
import com.mycompany.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CarWow";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "12345678";

    private static final String INSERT_USER_QUERY = "INSERT INTO user (User_Login, User_Password) VALUES (?, ?)";
    private static final String SELECT_ALL_USERS_QUERY = "SELECT * FROM users";

    private final UserRepository userRepository;
    private static UserService instance;

    public UserService() {
        userRepository = UserRepository.getInstance();
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public List<User> findAllUsers() {
        return new ArrayList<>(userRepository.findAllUsers());
    }

    public Optional<User> findUserById(int id) {
        return userRepository.findUserById(id);
    }

    public void deleteUserById(int id) {
        userRepository.deleteUserById(id);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}
