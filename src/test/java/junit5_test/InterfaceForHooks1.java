package junit5_test;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface InterfaceForHooks1 {
    @BeforeAll
    default void beforeAllOfAll(TestInfo testInfo) {
        System.out.println();
        System.out.println("Before in InterfaceForHooks1");
        System.out.println("testInfo.getDisplayName() = " + testInfo.getDisplayName());
        System.out.println("testInfo.getTags() = " + testInfo.getTags());
        System.out.println();
    }

    @AfterAll
    default void afterAllOfAll(TestInfo testInfo) {
        System.out.println();
        System.out.println("After in InterfaceForHooks1");
        System.out.println("testInfo.getDisplayName() = " + testInfo.getDisplayName());
        System.out.println("testInfo.getTags() = " + testInfo.getTags());
        System.out.println();
    }

    @BeforeEach
    default void beforeEach1(TestInfo testInfo) {
        System.out.println();
        System.out.println("start: base_before_each1");
        System.out.println("testInfo.getDisplayName() = " + testInfo.getDisplayName());
        System.out.println("testInfo.getTags() = " + testInfo.getTags());
        System.out.println("end: base_before_each1");
        System.out.println();
    }

    @AfterEach
    default void afterEach1(TestInfo testInfo) {
        System.out.println();
        System.out.println("start: base_after_each1");
        System.out.println("testInfo.getDisplayName() = " + testInfo.getDisplayName());
        System.out.println("testInfo.getTags() = " + testInfo.getTags());
        System.out.println("end: base_after_each1");
        System.out.println();
    }
}
