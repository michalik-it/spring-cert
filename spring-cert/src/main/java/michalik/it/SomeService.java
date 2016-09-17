package michalik.it;

import org.springframework.stereotype.Component;

@Component
public class SomeService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
