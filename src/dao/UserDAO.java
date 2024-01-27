package dao;

import entity.User;

public class UserDAO {

    User user1 = new User("user1", "user1@email.com", "password1");
    User user2 = new User("user2", "user2@email.com", "password2");
    User user3 = new User("user3", "user3@email.com", "password3");
    User user4 = new User("user4", "user4@email.com", "password4");
    User user5 = new User("user5", "user5@email.com", "password5");
    private User[] users;
    public UserDAO() {
        users = new User[]{user1, user2, user3, user4, user5};
    }

    public User[] findAllUsers() {
        return users;
    }
}
