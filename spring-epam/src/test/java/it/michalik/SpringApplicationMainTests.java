package it.michalik;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:application-config.xml")
public class SpringApplicationMainTests {

    
    @Test
    public void testContext() {
        System.out.println("Context ok");
    }
	
}
