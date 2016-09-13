package michalik.it;

import michalik.it.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig;
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
    
    @Test
    public void contextLoads() {
        System.out.println("Test start");
        transactionService.transfer(1, 2, 5000);
        transactionService.transfer(1, 2, 5000);
        transactionService.transfer(1, 2, 5000);
        System.out.println("Test end");
    }
    
    @Test
    public void test2() {
        System.out.println("Test 2 start");
        
        System.out.println("Test 2 end");
    }

}
