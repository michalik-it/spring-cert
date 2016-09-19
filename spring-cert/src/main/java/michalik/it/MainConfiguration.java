package michalik.it;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.HashSet;
import java.util.Set;

@Configuration
@ComponentScan
@ImportResource("classpath:application-config-wtf.xml")
@EnableCaching
public class MainConfiguration {

	@Bean
	public SomeService someService() {
	    SomeService someService = new SomeService();
	    someService.setName("set via @Bean");
		return someService;
	}
	
	@Bean
	public CacheManager cacheManager() {
	    SimpleCacheManager mng = new SimpleCacheManager();
	    Set<Cache> caches = new HashSet<Cache>();
	    caches.add(new ConcurrentMapCache("users"));
	    mng.setCaches(caches);
	    return mng;
	}
}
