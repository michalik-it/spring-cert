package michalik.it.repository.impl;

import michalik.it.repository.TransactionRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    @Transactional(propagation=Propagation.REQUIRES_NEW)
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

    private void sleep(int seconds) {
    	try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	@Override
	public void method1() {
		String sql = "SELECT * FROM accounts WHERE id > 1";
		String sql2 = "SELECT * FROM accounts WHERE id = 9";
		
		System.out.println("m1 start");
		System.out.println("m1 reading");
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
		System.out.println("m1 red: " + result);
		System.out.println("m1 sleeping 2 sec");
		sleep(4);
		System.out.println("m1 waking up after 2 sec");
		System.out.println("m1 reading");
		result = jdbcTemplate.queryForList(sql2);
		System.out.println("m1 red: " + result);
		System.out.println("m1 end");
	}

	@Override
	public void method2() {
		//String sql = "UPDATE accounts SET amount=666 WHERE id=1;";
		String sql = "INSERT INTO accounts VALUES(9,'janXXX',9)";
		System.out.println("m2 start");
		System.out.println("m2 sleeping 1 sec");
		sleep(1);
		System.out.println("m2 waking up after 1 sec");
		System.out.println("m2 updating/inserting");
		jdbcTemplate.update(sql);
		System.out.println("m2 updated/inserting");

		System.out.println("m2 end");		
	}
}
