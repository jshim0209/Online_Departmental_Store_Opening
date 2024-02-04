package entity;

import java.util.Objects;

public class User {
    private int userId;
    private String username;
    private String emailId;
    private String password;
    private int superCoins;
    private boolean isAdmin;

    public User() {
    }

    public User(String username, String emailId, String password) {
        super();
        this.username = username;
        this.emailId = emailId;
        this.password = password;
    }

    public User(String username, String emailId, String password, int superCoins, boolean isAdmin) {
        this.username = username;
        this.emailId = emailId;
        this.password = password;
        this.superCoins = superCoins;
        this.isAdmin = isAdmin;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSuperCoins() {
        return superCoins;
    }

    public void setSuperCoins(int superCoins) {
        this.superCoins = superCoins;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && superCoins == user.superCoins && isAdmin == user.isAdmin && Objects.equals(username, user.username) && Objects.equals(emailId, user.emailId) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, emailId, password, superCoins, isAdmin);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", superCoins=" + superCoins +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
