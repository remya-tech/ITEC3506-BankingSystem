package userAuth;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class UserTest {
    @Test
    void testUserCreation() {
        User user = new User("U1", "Alice", "alice@example.com", "1234567890", "password", "customer");

        assertEquals("U1", user.getUserId());
        assertEquals("Alice", user.getName());
        assertEquals("alice@example.com", user.getEmail());
        assertEquals("1234567890", user.getPhoneNumber());
        assertEquals("customer", user.getRole());
    }
}public class UserTest {
    public static void main(String[] args) {
        User user = new User("U1", "Alice", "alice@example.com", "1234567890", "password", "customer");
        System.out.println(user); // This will call the toString() method
    }
}# ITEC3506-BankingSystem