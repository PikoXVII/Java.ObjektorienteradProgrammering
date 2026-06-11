package banking.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Serializable User klass.
 * Innehåller personuppgifter och ett hashat lösenord.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String hashedPassword;

    public User(String username, String firstName, String lastName,
                String address, String phoneNumber, String plainPassword) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.hashedPassword = hashPassword(plainPassword);
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public boolean checkPassword(String input) {
        return Objects.equals(hashedPassword, hashPassword(input));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("SHA-256 not available", e);
        }
    }

    @Override
    public String toString() {
        return username + " (" + firstName + " " + lastName + ")";
    }
}
