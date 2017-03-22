import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class CityTest {

  @Test
  public void City_instantiatesCorrectly(){
    City testCity = new City("Portland");
    assertTrue(testCity instanceof City);
  }

  @Test
  public void all_hasSizeGreaterThanOne_true(){
    City testCity1 = new City("Newark");
    City testCity2 = new City("Phoenix");
    assertEquals(2, City.all().size());
  }

  @Test
  public void find_returnsSecondCity_true(){
    City testCity1 = new City("Dallas");
    City testCity2 = new City("Seattle");
    assertEquals(testCity2, City.find(2));
  }

  @Test
  public void getJobOpenings_initiallyReturnsEmptyList_ArrayList(){
    City testCity1 = new City("Springfield");
    assertEquals(0, testCity1.getJobOpenings().size());

  }

  @Test
  public void addJobOpening_addsJobOpeningToList_true(){
    City testCity1 = new City("Atlanta");
    JobOpening testJob = new JobOpening("Cool job", "So interesting", "bestBoss@gmail.com");
    testCity1.addJobOpening(testJob);
    assertTrue(testCity1.getJobOpenings().contains(testJob));
  }

  @After
  public void tearDown(){
    City.clear();
  }
}
