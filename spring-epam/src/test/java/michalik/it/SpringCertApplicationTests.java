package michalik.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Sql(value={"classpath:db-schema.sql", "classpath:db-insert.sql"}, executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(scripts={"classpath:db-delete.sql"}, executionPhase=ExecutionPhase.AFTER_TEST_METHOD)

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:application-config.xml")
public class SpringCertApplicationTests {

    @Autowired
    private Service service;
    
    @Test
    public void test() {
        System.out.println(service);
    }

}
