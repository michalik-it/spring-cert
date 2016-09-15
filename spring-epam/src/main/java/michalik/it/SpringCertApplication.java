package michalik.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCertApplication {

	public static void main(String[] args) {
	    ConfigurableApplicationContext appCtx =
                new ClassPathXmlApplicationContext("application-config.xml");
        
	   
        SomeService service = appCtx.getBean(SomeService.class);
        service.call();
       
        appCtx.close(); 
        
        System.out.println("SpringCertApplication.main()");
	}
}
