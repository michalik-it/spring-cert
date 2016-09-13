package michalik.it.service;

public interface TransactionService {
    void transfer(int fromAccountId, int toAccountId, int amount);
}
