package michalik.it.repository;

public interface TransactionRepository {
    public void transfer(int fromAccountId, int toAccountId, int amount);
    public void debit(int accountId, int amount);
    public void credit(int accountId, int amount);
    public int getBalance(int accountId);
    public void setBalance(int accountId, int amount);
    
    public void method1();
    public void method2();
}
