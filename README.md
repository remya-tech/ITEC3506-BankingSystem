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
class User {
    private String userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;
    public User(String userId, String name, String email, String phoneNumber, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.setPassword(password);
        this.role = role;
        }
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; 
    }
    public String getRole() { return role; }
    // Override toString() for easy printing
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                '}'; 
                }
	public String getPassword() {
		return password;	}
	public void setPassword(String password) {
		this.password = password;
	}

}# ITEC3506-BankingSystem