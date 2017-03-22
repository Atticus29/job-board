import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class City {
  private String mName;
  private static Map<String, City> instances = new HashMap<String, City>();
  private List<JobOpening> mJobOpenings;
  // private int mId;

  public City(String name){
    mName = name;
    instances.put(name, this);
    mJobOpenings = new ArrayList<JobOpening>();
    // mId = instances.size();
  }

  public static Map<String, City> all(){

    return instances;
  }

  // public static City find(int number){
  //   return instances.get(number-1);
  // }

  public static void clear(){
    instances.clear();
  }

  public List<JobOpening> getJobOpenings(){
    return mJobOpenings;
  }

  public void addJobOpening(JobOpening job){
    mJobOpenings.add(job);
  }

  public String getName(){
    return mName;
  }

  // public int getId(){
  //   return mId;
  // }

  public static City findByName(String name){
    return instances.get(name);
  }

}
