package dto;

import java.util.Objects;

public class UserResponseDTO {
    private String username;
    private String email;
    private int superCoins;
    private boolean isAdmin;

    public UserResponseDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        UserResponseDTO that = (UserResponseDTO) o;
        return superCoins == that.superCoins && isAdmin == that.isAdmin && Objects.equals(username, that.username) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, superCoins, isAdmin);
    }

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", superCoins=" + superCoins +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
