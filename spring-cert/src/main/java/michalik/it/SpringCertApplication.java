package michalik.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import michalik.it.configuration.MainConfiguration;
import michalik.it.service.TransactionService;

@SpringBootApplication
@ComponentScan
@ImportResource("classpath:application-config.xml")
public class SpringCertApplication {

	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringCertApplication.class, args);
		
		/*
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
		//ConfigurableApplicationContext context = SpringApplication.run(MainConfiguration.class);
		omeService ss = context.getBean(SomeService.class);
		System.out.println(ss.getName());
		*/
		
		
		TransactionService ts = context.getBean(TransactionService.class);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				ts.method1();
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				ts.method2();
			}
		});
		t2.start();
		
		t1.join();
		t2.join();
		
		context.stop();
		context.close();
		
	}
}
