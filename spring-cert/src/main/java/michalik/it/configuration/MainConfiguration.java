package michalik.it.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import michalik.it.SomeService;

@Configurable
@ComponentScan(basePackages={"michalik"})
public class MainConfiguration {

//	@Bean
//	public SomeService someService() {
//		return new SomeService();
//	}
}
