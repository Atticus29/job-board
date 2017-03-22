import org.junit.*;
import static org.junit.Assert.*;

public class JobOpeningTest {
  @Test
  public void newJobOpening_instantiatesCorrectly_true(){
    JobOpening testJobOpening = new JobOpening("test", "test", "999-999-9999");
    assertEquals(true, testJobOpening instanceof JobOpening);
  }

  @Test
  public void getTitle_returnsTitle_test(){
    JobOpening testJobOpening = new JobOpening("test", "test", "999-999-9999");
    assertEquals("test", testJobOpening.getTitle());
  }

  @Test
  public void getDescription_returnsDescription_test(){
    JobOpening testJobOpening = new JobOpening("test", "test", "999-999-9999");
    assertEquals("test", testJobOpening.getDescription());
  }

  @Test
  public void getContact_returnsContact_9999999999(){
    JobOpening testJobOpening = new JobOpening("test", "test", "9999999999");
    assertEquals("9999999999", testJobOpening.getContact());
  }
}
