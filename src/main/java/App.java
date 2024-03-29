import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/city-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("cities", City.all());
      model.put("template", "templates/cities.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.findByName(request.params(":id"));

      model.put("city", city);
      model.put("template", "templates/city.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id/jobOpenings/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.findByName(request.params(":id"));
      model.put("city", city);
      model.put("template", "templates/city-jobOpenings-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      City newCity = new City(name);
      model.put("city", newCity);
      model.put("template", "templates/city-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/jobOpenings", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.findByName(request.queryParams("cityName"));
      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String contact = request.queryParams("contact");
      JobOpening job = new JobOpening(title, description, contact);
      city.addJobOpening(job);

      model.put("city", city);
      model.put("template", "templates/city-jobOpenings-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // get("/jobOpenings", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   City city = City.find(Integer.parseInt(request.params("cityId")));
    //   model.put("city", city);
    //   model.put("template", "templates/city-jobOpenings-form.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
  }
}
