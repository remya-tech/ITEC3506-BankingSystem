package account;

public class BankingSystem<accounts, Account> {
private List<User> users = new ArrayList<>();
private List<Account> accounts = new ArrayList<>();

public void registerUser(String userId, String name, String email, String phoneNumber, String password, String role) {
    users.add(new User(userId, name, email, phoneNumber, password, role));
}

public void createAccount(String accountId, String userId, String accountType, double balance) {
    accounts.add(new Account(accountId, userId, accountType, balance));
}

public Account getAccountById(String accountId) {
    for (Account acc : accounts) {
        if (acc.getAccountId().equals(accountId)) {
            return acc;
        }
    }
    return null;
}

public boolean transferFunds(String fromAccountId, String toAccountId, double amount) {
    Account fromAccount = getAccountById(fromAccountId);
    Account toAccount = getAccountById(toAccountId);
    
    if (fromAccount != null && toAccount != null && fromAccount.withdraw(amount)) {
        toAccount.deposit(amount);
        return true;
    }
    return false;
}
}
}




	