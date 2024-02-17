package pets;

import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

public class ManagmentTest {
    @Test
    void testParallel(){
        Runner.path("classpath:pets").tags("~@ignore").parallel(1);
    }
}
