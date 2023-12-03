package com.mycompany.repository;

import com.mycompany.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static final String INSERT_USER_QUERY = "INSERT INTO user (User_Login, User_Password) VALUES (?, ?)";
    private static final String SELECT_ALL_USERS_QUERY = "SELECT * FROM user";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE User_ID = ?";

    private static final String DELETE_USER_BY_ID_QUERY = "DELETE FROM user WHERE User_ID = ?";

    private static final String UPDATE_USER_QUERY = "UPDATE user SET User_Login = ?, User_Password = ? WHERE User_ID = ?";
    private static UserRepository instance;
    private final Connection connection;

    private UserRepository() {
        connection = DatabaseConnector.getInstance();
    }

    public static synchronized UserRepository getInstance() {
        if(instance == null) {
            instance = new UserRepository();
        }

        return instance;
    }

    public List<User> findAllUsers() {
        List<User> userList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User(
                        Integer.parseInt(resultSet.getString("User_ID")),
                        resultSet.getString("User_Login"),
                        resultSet.getString("User_password")
                );
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public void addUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<User> findUserById(int userId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(new User(
                        Integer.parseInt(resultSet.getString("User_ID")),
                        resultSet.getString("User_Login"),
                        resultSet.getString("User_Password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void deleteUserById(int userId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID_QUERY)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
