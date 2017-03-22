import java.util.List;
import java.util.ArrayList;

public class JobOpening {
  private String mTitle;
  private String mDescription;
  private String mContact;
  private static List<JobOpening> instances = new ArrayList<JobOpening>();

  public JobOpening(String title, String description, String contact){
    mTitle = title;
    mDescription = description;
    mContact = contact;
    instances.add(this);
  }

  public String getTitle(){
    return mTitle;
  }

  public String getDescription(){
    return mDescription;
  }

  public String getContact(){
    return mContact;
  }

  public static void clear(){
    instances.clear();
  }

  public static JobOpening find(int number){
    return instances.get(number-1);
  }

  public static List<JobOpening> all(){
    return instances;
  }


}
