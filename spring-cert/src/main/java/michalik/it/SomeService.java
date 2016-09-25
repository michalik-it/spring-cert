package michalik.it;

import org.hsqldb.lib.HashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

@Component
public class SomeService {
    
    private String name = "orginal";
    private Map<String, String> users;
    
    @Value("${app.someprop:default}")
    private String someProperty;
    
    
    public SomeService() {
        super();
    }
    
    public SomeService(String name) {
        super();
        this.name = name;
    }

    @PostConstruct
    public void init() {
        users = new TreeMap<String, String>();
        users.put("k", "Kamil");
        users.put("j", "Jan");
        users.put("w", "Will");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Cacheable(value="users", key="#id")
    public String getUser(String id) {
        System.out.println("SomeService.getUser(\"" + id + "\")");
        return users.get(id);
    }
    
    @CacheEvict(value="users", allEntries=true)
    public void refreshUsers() {
//        users = new TreeMap<String, String>();
//        users.put("k", "Kamil refreshed");
//        users.put("j", "Jan refreshed");
//        users.put("w", "Will refreshed");
    }

	public String getSomeProperty() {
		return someProperty;
	}

	public void setSomeProperty(String someProperty) {
		this.someProperty = someProperty;
	}
    
    
    
}

	