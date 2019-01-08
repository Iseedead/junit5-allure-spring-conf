package junit5_test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Tag("tag_for_all")
@ExtendWith(SpringExtension.class)
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BaseAfterEachCallback.class)
public abstract class SomeAbstractTest implements InterfaceForHooks1 {
}
