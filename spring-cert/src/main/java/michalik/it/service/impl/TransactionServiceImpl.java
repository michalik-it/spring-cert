package michalik.it.service.impl;

import michalik.it.repository.TransactionRepository;
import michalik.it.service.TransactionService;
import org.springframework.stereotype.Component;

public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void transfer(int fromAccountId, int toAccountId, int amount) {
        transactionRepository.transfer(fromAccountId, toAccountId, amount);
    }
    
    @Override
    public int getBalance(int accountId) {
        return transactionRepository.getBalance(accountId);
    }

}
