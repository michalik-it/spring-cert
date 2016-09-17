package michalik.it.service.impl;

import michalik.it.repository.TransactionRepository;
import michalik.it.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

//@Component
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public void transfer(int fromAccountId, int toAccountId, int amount) {
        transactionRepository.transfer(fromAccountId, toAccountId, amount);
    }
    
    @Override
    @Transactional
    public void transfer3(int fromAccountId, int toAccountId, int amount) {
    	transactionRepository.transfer(fromAccountId, toAccountId, amount);
    	transactionRepository.transfer(fromAccountId, toAccountId, amount);
    	transactionRepository.transfer(fromAccountId, toAccountId, amount);
    }
    
    @Override
    public int getBalance(int accountId) {
        return transactionRepository.getBalance(accountId);
    }

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public void method1() {
		transactionRepository.method1();
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public void method2() {
		transactionRepository.method2();
		
	}

}
