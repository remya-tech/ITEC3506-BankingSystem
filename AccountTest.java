package Bank;


public class AccountTest {
	
	    private String accountId;
	    private String userId;
	    private String accountType;
	    private double balance;

	    public AccountTest(String accountId, String userId, String accountType, double balance) {
	        this.accountId = accountId;
	        this.userId = userId;
	        this.accountType = accountType;
	        this.balance = balance;
	    }

	    public String getAccountId() {
	        return accountId;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public String getAccountType() {
	        return accountType;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	        this.balance += amount;
	    }

	    public boolean withdraw(double amount) {
	        if (amount <= this.balance) {
	            this.balance -= amount;
	            return true;
	        }
	        return false;
	    }
	}
