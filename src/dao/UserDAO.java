package dao;

import dto.UserRequestDTO;
import dto.UserResponseDTO;
import entity.User;
import utility.ConnectionUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserDAO() {
        connection = ConnectionUtility.getConnection();
    }

    public User findUserByUsername(String username) {
        try {
            String sql = "SELECT * FROM Users WHERE username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String usernameRetrieved = resultSet.getString("username");
                String email = resultSet.getString("email_id");
                String password = resultSet.getString("password");
                int superCoins = resultSet.getInt("super_coins");
                boolean isAdmin = resultSet.getBoolean("is_admin");
                User returnedUser = new User(usernameRetrieved, email, password, superCoins, isAdmin);
                return returnedUser;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public UserResponseDTO createAccount(UserRequestDTO userRequestDTO) {
        try {
            String sql = "INSERT INTO Users (username, email_id, password, super_coins, is_admin) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userRequestDTO.getUsername());
            preparedStatement.setString(2, userRequestDTO.getEmail());
            preparedStatement.setString(3, userRequestDTO.getPassword());
            preparedStatement.setInt(4, 100);
            preparedStatement.setBoolean(5, false);
            int numberOfUsersInserted = preparedStatement.executeUpdate();
            if (numberOfUsersInserted > 0) {
                System.out.println("User registered successfully!!");
                return new UserResponseDTO(userRequestDTO.getUsername(), userRequestDTO.getEmail());
            } else {
                System.out.println("User registration failed...");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
