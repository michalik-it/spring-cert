package michalik.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MainConfiguration.class})
public class WTFTests {

    @Autowired
    SomeService someService;
    
    @Test
    public void test1() {
        System.out.println("someService.getName(): " + someService.getName());
    }
    
    public static void main(String... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        
        SomeService s = context.getBean(SomeService.class);
        
        System.out.println(s.getName());
        
    }
    

}