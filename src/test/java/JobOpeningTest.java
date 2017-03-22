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

  @Test
  public void clear_removesAllJobOpenings_true(){
    JobOpening testJobOpening1 = new JobOpening("test1", "test", "9999999999");
    JobOpening testJobOpening2 = new JobOpening("test2", "test", "9999999999");
    assertEquals(2, JobOpening.all().size());
    JobOpening.clear();
    assertEquals(0, JobOpening.all().size());
  }

  @Test
  public void find_returnsSecondJobOpening_true(){
    JobOpening testJobOpening1 = new JobOpening("dreamJob", "test", "9999999999");
    JobOpening testJobOpening2 = new JobOpening("NightmareJob", "test", "9999999999");
    assertEquals(testJobOpening2, JobOpening.find(2));
  }

  @Test
  public void all_listsAllJobOpenings_true(){
    JobOpening testJobOpeningDream = new JobOpening("dreamJob", "test", "9999999999");
    JobOpening testJobOpeningNightmare = new JobOpening("NightmareJob", "test", "9999999999");
    assertEquals(2, JobOpening.all().size());
  }

  @After
  public void tearDown(){
    JobOpening.clear();
  }
}
