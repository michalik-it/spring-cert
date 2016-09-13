package michalik.it.repository.impl;

import michalik.it.repository.TransactionRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.security.InvalidParameterException;

import javax.sql.DataSource;

public class TransactionRepositoryImpl implements TransactionRepository {
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    public TransactionRepositoryImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public void transfer(int fromAccountId, int toAccountId, int amount) {
        debit(fromAccountId, amount);
        credit(toAccountId, amount);
    }

    @Override
    public void debit(int accountId, int amount) {
        int balance = getBalance(accountId);
        if (balance - amount < 0)
            throw new InvalidParameterException("Not enough money bitch");
        setBalance(accountId, balance - amount);
    }

    @Override
    public void credit(int accountId, int amount) {
        int balance = getBalance(accountId);
        setBalance(accountId, balance + amount);
    }

    @Override
    public int getBalance(int accountId) {
        String sql = "SELECT amount FROM accounts WHERE id=?";

        Integer amount = (Integer) jdbcTemplate.queryForObject(sql, new Object[] {accountId},
                Integer.class);

        return amount;
    }

    @Override
    public void setBalance(int accountId, int amount) {
        String sql = "UPDATE accounts SET amount=? WHERE id=?;";

        jdbcTemplate.update(sql, new Object[] {amount, accountId});
    }
}
