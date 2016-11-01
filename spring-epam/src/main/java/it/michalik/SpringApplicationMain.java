package it.michalik;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplicationMain implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringApplicationMain.class);
	
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("SpringApplicationMain.run()");
		
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationMain.class, args);
	   
	}

	
}
