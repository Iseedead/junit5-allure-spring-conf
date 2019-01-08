package junit5_test;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BaseAfterEachCallback implements AfterTestExecutionCallback {
    private boolean isFailed;

    @Override
    public void afterTestExecution(ExtensionContext context) {
        System.out.println();
        System.out.println("start: after_test_callback");
        System.out.println("context.getTags() = " + context.getTags());
        System.out.println("context.getUniqueId() = " + context.getUniqueId());
        System.out.println("context.getDisplayName() = " + context.getDisplayName());
        System.out.println("context.getExecutionException() = " + context.getExecutionException());
        isFailed = context.getExecutionException().isPresent();
        System.out.println("isFailed = " + isFailed);
        System.out.println("end: after_test_callback");
        System.out.println();
    }
}
