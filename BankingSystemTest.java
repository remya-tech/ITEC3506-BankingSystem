package account;
	
	
	
	import java.util.List;

	
	class BankingSystemTest {
	    private BankingSystem<Account> bankingSystem;
	    private User user1;
	    private Account account1;
	    private Account account2;

	    @BeforeEach
	    void setUp() {
	        // Initialize the BankingSystem before each test
	        bankingSystem = new BankingSystem<>();

	        // Register a user
	        bankingSystem.registerUser("user1", "John Doe", "john@example.com", "1234567890", "password", "customer");
	        user1 = new User("user1", "John Doe", "john@example.com", "1234567890", "password", "customer");

	        // Create accounts for the user
	        bankingSystem.createAccount("acc1", "user1", "checking", 1000.0);
	        bankingSystem.createAccount("acc2", "user1", "savings", 500.0);
	        
	        // Get created accounts
	        account1 = bankingSystem.getAccountById("acc1");
	        account2 = bankingSystem.getAccountById("acc2");
	    }

	    @Test
	    void testRegisterUser() {
	        // Test user registration
	        List<User> users = bankingSystem.getUsers();
	        assertEquals(1, users.size());
	        assertEquals("John Doe", users.get(0).getName());
	    }

	    @Test
	    void testCreateAccount() {
	        // Test account creation
	        assertNotNull(account1);
	        assertEquals("acc1", account1.getAccountId());
	        assertEquals(1000.0, account1.getBalance());
	    }

	    @Test
	    void testGetAccountById() {
	        // Test fetching an account by ID
	        Account fetchedAccount = bankingSystem.getAccountById("acc1");
	        assertNotNull(fetchedAccount);
	        assertEquals("acc1", fetchedAccount.getAccountId());
	    }

	    @Test
	    void testTransferFunds() {
	        // Test fund transfer between two accounts
	        boolean transferSuccess = bankingSystem.transferFunds("acc1", "acc2", 200.0);

	        // Check if the transfer was successful
	        assertTrue(transferSuccess);
	        assertEquals(800.0, account1.getBalance());
	        assertEquals(700.0, account2.getBalance());
	    }

	    @Test
	    void testInsufficientFundsTransfer() {
	        // Test transfer with insufficient funds
	        boolean transferSuccess = bankingSystem.transferFunds("acc1", "acc2", 2000.0);

	        // Check if the transfer failed due to insufficient funds
	        assertFalse(transferSuccess);
	        assertEquals(1000.0, account1.getBalance());
	        assertEquals(500.0, account2.getBalance());
	    }

	    @Test
	    void testInvalidAccountTransfer() {
	        // Test transfer with invalid account IDs
	        boolean transferSuccess = bankingSystem.transferFunds("invalidAcc1", "invalidAcc2", 100.0);

	        // Check if the transfer failed due to invalid account IDs
	        assertFalse(transferSuccess);
	    }
	}

