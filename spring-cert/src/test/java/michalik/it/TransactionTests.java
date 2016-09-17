package michalik.it;

import michalik.it.service.TransactionService;
import michalik.it.service.impl.TransactionServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:application-config.xml")
public class TransactionTests {

    @Autowired
    TransactionService transactionService;
    
    @Test
    @Transactional
    public void test() {
        
        transactionService.transfer(1, 2, 5000);
        Assert.assertEquals(transactionService.getBalance(1), 5000);
        
    }
}
