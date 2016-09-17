package michalik.it.service;

public interface TransactionService {
    void transfer(int fromAccountId, int toAccountId, int amount);
    int getBalance(int accountId);
    
    public void method1();
    public void method2();
	void transfer3(int fromAccountId, int toAccountId, int amount);
}
