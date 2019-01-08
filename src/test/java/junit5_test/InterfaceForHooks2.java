package junit5_test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public interface InterfaceForHooks2 {
    @BeforeEach
    default void beforeEach2(TestInfo testInfo) {
        System.out.println();
        System.out.println("start: base_before_each2");
        System.out.println("testInfo.getDisplayName() = " + testInfo.getDisplayName());
        System.out.println("testInfo.getTags() = " + testInfo.getTags());
        System.out.println("end: base_before_each2");
        System.out.println();
    }

    @AfterEach
    default void afterEach2(TestInfo testInfo) {
        System.out.println();
        System.out.println("start: base_after_each2");
        System.out.println("testInfo.getDisplayName() = " + testInfo.getDisplayName());
        System.out.println("testInfo.getTags() = " + testInfo.getTags());
        System.out.println("end: base_after_each2");
        System.out.println();
    }
}
