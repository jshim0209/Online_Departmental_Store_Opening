package service;

import dao.UserDAO;
import dto.UserRequestDTO;
import dto.UserResponseDTO;
import entity.User;
import exception.BadRequestException;
import exception.ExistingUserException;
import exception.InvalidCredentialsException;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    private void validateUserRequest(UserRequestDTO userRequestDTO) throws BadRequestException {
        if (userRequestDTO.getUsername() == null ||
                userRequestDTO.getEmail() == null ||
                userRequestDTO.getPassword() == null) {
            throw new BadRequestException("You must provide all the required fields for the request.");
        }
    }

    public UserResponseDTO createAccount(UserRequestDTO userRequestDTO) throws BadRequestException, ExistingUserException {
        validateUserRequest(userRequestDTO);
        String username = userRequestDTO.getUsername();
        if (findUser(username) != null) {
            throw new ExistingUserException("Username is already taken!");
        } else {
            return userDAO.createAccount(userRequestDTO);
        }
    }

    private User findUser(String username) {
        return userDAO.findUserByUsername(username);
    }

//    public boolean createAccount(User user) {
//        return userDAO.createAccount(user);
//    }

    public boolean authenticate(String username, String password) throws InvalidCredentialsException {
        User user = findUser(username);
        if (!user.getPassword().equals(password)){
            throw new InvalidCredentialsException("Invalid credentials provided!");
        }
        return user.isAdmin();
    }
}
