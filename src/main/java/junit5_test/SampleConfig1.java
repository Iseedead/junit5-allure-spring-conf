package junit5_test;

import io.qameta.allure.Step;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan
public class SampleConfig1 {
    private final Someone someone;

    public SampleConfig1(Someone someone) {
        this.someone = someone;
    }

    @PostConstruct
    void postConstruct() {
        System.out.println();
        System.out.println("SampleConfig1 constructed");
        System.out.println("someone = " + someone);
        System.out.println();
    }

    @Step("Allure step here")
    public void doSomething(Something something) {
        someone.doSomething(something);
    }

    public boolean isSomethingDone(Something something) {
        return something.getStatus().equalsIgnoreCase("Done");
    }
}
