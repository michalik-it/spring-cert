package michalik.it.service;

import org.springframework.cache.annotation.Cacheable;

public interface TransactionService {
    void transfer(int fromAccountId, int toAccountId, int amount);
    
    @Cacheable(cacheNames="balanceCache")
    int getBalance(int accountId);
    
    public void method1();
    public void method2();
	void transfer3(int fromAccountId, int toAccountId, int amount);
}
