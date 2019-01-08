package junit5_test;

import org.springframework.stereotype.Component;

@Component
public class Someone {
    public void doSomething(Something something) {
        System.out.println("Doing '" + something + "'");
        something.setStatus("Done");
    }
}
