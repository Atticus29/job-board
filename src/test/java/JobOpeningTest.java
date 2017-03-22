import org.junit.*;
import static org.junit.Assert.*;

public class JobOpeningTest {
  @Test
  public void newJobOpening_instantiatesCorrectly_true(){
    JobOpening testJobOpening = new JobOpening("test", "test", "999-999-9999");
    assertEquals(true, testJobOpening instanceof JobOpening);
  }
}
