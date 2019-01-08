package junit5_test.test_pkg;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import junit5_test.SampleConfig1;
import junit5_test.SomeAbstractTest;
import junit5_test.Someone;
import junit5_test.Something;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@Tag("class_tag1")
@Tag("class_tag2")
@DisplayName("'@DisplayName' of class2")
@ContextConfiguration(classes = SampleConfig1.class)
class SampleTestClass2 extends SomeAbstractTest {
    @Autowired
    private SampleConfig1 sampleConfig1;
    @Autowired
    private Someone someone;

    @BeforeAll
    static void beforeAll(TestInfo testInfo) {
        System.out.println("========================================================================================");
        System.out.println("Before SampleTestClass2");
        System.out.println("testInfo.getDisplayName() = " + testInfo.getDisplayName());
        System.out.println("testInfo.getTags() = " + testInfo.getTags());
        System.out.println();
    }

    @AfterAll
    static void afterAll(TestInfo testInfo) {
        System.out.println();
        System.out.println("After SampleTestClass2");
        System.out.println("testInfo.getDisplayName() = " + testInfo.getDisplayName());
        System.out.println("testInfo.getTags() = " + testInfo.getTags());
        System.out.println("========================================================================================");
    }

    @Test
    @Tag("spring_tag")
    @DisplayName("Spring Test")
    @Description("LOL_KEK")
    @Issue("CPA-??")
    @TmsLink("CP-????")
    void spring_test() {
        System.out.println();
        System.out.println("I am spring test");
        System.out.println("someone = " + someone);
        System.out.println("sampleConfig1 = " + sampleConfig1);

        Something something = new Something("name of something");
        sampleConfig1.doSomething(something);
        boolean isDone = sampleConfig1.isSomethingDone(something);
        System.out.println("isDone = " + isDone);
        allure_step();
    }

    @Test
    @Tag("selenium_tag")
    @DisplayName("selenium Test2")
    @Description("LOL_KEK")
    @Issue("CPA-??")
    @TmsLink("CP-????")
    void fail_selenium_test() throws Throwable {
        System.out.println();
        System.out.println("I am selenium test2");

        System.setProperty("webdriver.chrome.driver", "/Users/pavel.sivkovych/Work/junit5_test/src/main/resources/drivers/chromedriver.mac");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(10000);
        driver.quit();
        throw new Throwable("Yep, I thew Throwable");
    }

    @Step("0 Allure step with mapped name and status: {something.name}, {something.status}")
    public void allure_step() {
        int a = 1;
        Assertions.assertEquals(a, 1);
    }
}
