import java.util.List;
import java.util.ArrayList;

public class City {
  private String mName;
  private static List<City> instances = new ArrayList<City>();
  private List<JobOpening> mJobOpenings;

  public City(String name){
    mName = name;
    instances.add(this);
    mJobOpenings = new ArrayList<JobOpening>();
  }

  public static List<City> all(){
    return instances;
  }

  public static City find(int number){
    return instances.get(number-1);
  }

  public static void clear(){
    instances.clear();
  }

  public List<JobOpening> getJobOpenings(){
    return mJobOpenings;
  }

  public void addJobOpening(JobOpening job){
    mJobOpenings.add(job);
  }

}
