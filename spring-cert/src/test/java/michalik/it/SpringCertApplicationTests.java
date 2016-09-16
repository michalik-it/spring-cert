package michalik.it;

import michalik.it.service.TransactionService;
import michalik.it.service.impl.TransactionServiceImpl;
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

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:application-config.xml")
@Sql(value={"classpath:db-schema.sql", "classpath:db-insert.sql"}, executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(scripts={"classpath:db-delete.sql"}, executionPhase=ExecutionPhase.AFTER_TEST_METHOD)
public class SpringCertApplicationTests {

    @Autowired
    TransactionService transactionService;
    
    @Autowired 
    private ApplicationContext applicationContext;
    
    @Autowired
    private SomeService someService;
    
    @Test
    //@DirtiesContext
    public void test1() {
        System.out.println("=======>" + someService.getName());
        System.out.println("test1() start");
        transactionService.transfer(1, 2, 5000);
        System.out.println("Balance for 1:" + transactionService.getBalance(1));
        System.out.println("test1() end");
    }
    
    @Test
    public void test2() {
        System.out.println("test2() start");
        System.out.println("Balance for 1:" + transactionService.getBalance(1));
        System.out.println("test2() end");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void test3() {
        System.out.println("test3() start");
        transactionService.transfer(1, 2, 5000);
        transactionService.transfer(1, 2, 5000);
        transactionService.transfer(1, 2, 5000);
        System.out.println("Balance for 1:" + transactionService.getBalance(1));
        System.out.println("test3() end");
    }

}
