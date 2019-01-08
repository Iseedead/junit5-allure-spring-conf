package junit5_test.test_pkg;

import junit5_test.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.fail;

@Tag("class_tag1")
@Tag("class_tag2")
@DisplayName("'@DisplayName' of class1")
@ContextConfiguration(classes = SampleConfig1.class)
class SampleTestClass1 extends SomeAbstractTest implements InterfaceForHooks2 {
    @Autowired
    private SampleConfig1 sampleConfig1;
    @Autowired
    private Someone someone;

    @BeforeAll
    static void beforeAll(TestInfo testInfo) {
        System.out.println("========================================================================================");
        System.out.println("Before SampleTestClass1");
        System.out.println("testInfo.getDisplayName() = " + testInfo.getDisplayName());
        System.out.println("testInfo.getTags() = " + testInfo.getTags());
        System.out.println();
    }

    @AfterAll
    static void afterAll(TestInfo testInfo) {
        System.out.println();
        System.out.println("After SampleTestClass1");
        System.out.println("testInfo.getDisplayName() = " + testInfo.getDisplayName());
        System.out.println("testInfo.getTags() = " + testInfo.getTags());
        System.out.println("========================================================================================");
    }

    @Test
    @Tag("selenium_tag")
    @DisplayName("selenium Test1")
    void selenium_test() throws InterruptedException {
        System.out.println();
        System.out.println("I am selenium test1");

        System.setProperty("webdriver.chrome.driver", "/Users/pavel.sivkovych/Work/junit5_test/src/main/resources/drivers/chromedriver.mac");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    @Tag("spring_tag")
    @DisplayName("Spring Test")
    void spring_test() {
        System.out.println();
        System.out.println("I am spring test");
        System.out.println("someone = " + someone);
        System.out.println("sampleConfig1 = " + sampleConfig1);

        Something something = new Something("name of something");
        sampleConfig1.doSomething(something);
        boolean isDone = sampleConfig1.isSomethingDone(something);
        System.out.println("isDone = " + isDone);
    }

    @Test
    @Tag("method_tag1")
    @DisplayName("'@DisplayName' of method1")
    void test1() {
        System.out.println();
        System.out.println("I am sample test1");
        System.out.println();
    }

    @Test
    @Tag("method_tag2")
    @DisplayName("'@DisplayName' of method2")
    void test2() {
        System.out.println();
        System.out.println("I am sample test2");
        System.out.println("I am going to fail with assertion error");
        System.out.println("Look!");
        fail("Fail Msg");
        System.out.println();
    }

    @Test
    @Tag("method_tag3")
    @DisplayName("'@DisplayName' of method3")
    void test3() {
        System.out.println();
        System.out.println("I am sample test3");
        System.out.println("I am going to fail with custom error");
        System.out.println("Look!");
        throw new RuntimeException("Hello there");
    }

    @Test
    @Tag("method_tag4")
    @DisplayName("'@DisplayName' of method4")
    void test4() {
        System.out.println();
        System.out.println("I am sample test4");
        System.out.println("I am going to fail with custom error");
        System.out.println("Look!");
        throw new NullPointerException("NPE, MOTHER FUCKER!");
    }
}
