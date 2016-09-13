package michalik.it.service.impl;

import michalik.it.repository.TransactionRepository;
import michalik.it.service.TransactionService;
import org.springframework.stereotype.Component;

//@Component
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        super();
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void transfer(int fromAccountId, int toAccountId, int amount) {
        transactionRepository.transfer(fromAccountId, toAccountId, amount);
    }

}
