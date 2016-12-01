import java.sql.*;
import java.util.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import static spark.Spark.*;

//import javafx.beans.binding.ObjectExpression;
import org.eclipse.jetty.server.Authentication;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import spark.Request;
import spark.Response;
import spark.Route;



import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main {



  public static UsersDbService<Users> usersDbService = new UsersPostgresDao<Users>();
  public static CoursesDbService<Courses> coursesDbService = new CoursesPostgresDao<Courses>();
  public static InstructorsDbService<Instructors> instructorsDbService = new InstructorsPostgresDao<Instructors>();



  public static void main(String[] args) {

    Gson gson = new Gson();




    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");
    externalStaticFileLocation("/public/index.html");

    get("/hello", (req, res) -> "Hello World");
    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

    get("/index", (request, response) -> {
       return new ModelAndView(new HashMap(), "index.ftl");
    }, new FreeMarkerEngine());

    get("/newCourses", (request, response) -> {
      return new ModelAndView(new HashMap(), "newCourses.ftl");
    }, new FreeMarkerEngine());

    get("/allCourses", (request, response) -> {
      return new ModelAndView(new HashMap(), "allCourses.ftl");
    }, new FreeMarkerEngine());

    get("/shortTutorials", (request, response) -> {
      return new ModelAndView(new HashMap(), "shortTutorials.ftl");
    }, new FreeMarkerEngine());

    get("/instructors", (request, response) -> {
      return new ModelAndView(new HashMap(), "instructors.ftl");
    }, new FreeMarkerEngine());

    get("/aboutUS", (request, response) -> {
      return new ModelAndView(new HashMap(), "aboutUS.ftl");
    }, new FreeMarkerEngine());

    get("/courseManagement", (request, response) -> {
      return new ModelAndView(new HashMap(), "courseManagement.ftl");
    }, new FreeMarkerEngine());

    get("/login", (request, response) -> {
      return new ModelAndView(new HashMap(), "login.ftl");
    }, new FreeMarkerEngine());

    get("/signup", (request, response) -> {
      return new ModelAndView(new HashMap(), "signup.ftl");
    }, new FreeMarkerEngine());

    get("/api", (request, response) -> {
      Map<String, Object> viewObjects = new HashMap<String, Object>();

      viewObjects.put("templateName", "api.ftl");
      return modelAndView(viewObjects, "layout.ftl");
    }, new FreeMarkerEngine());


    post("/insert_users", (request, response) -> {

      String firstName = request.queryParams("first-name");
      String lastName = request.queryParams("last-name");
      String username = request.queryParams("user-name");
      String password = request.queryParams("user-password");

      Connection connection = null;
      PreparedStatement pst = null;

      Map<String, Object> attributes = new HashMap<>();

      try{

        connection = DatabaseUrl.extract().getConnection();
        String sql = "INSERT INTO users(firstName, lastName, username, password) VALUES(?, ?, ?, ?)";
        pst = connection.prepareStatement(sql);

        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, username);
        pst.setString(4, password);

        pst.executeUpdate();

        attributes.put("message", "Success!! Thank you for registering");
        return new ModelAndView(attributes, "error.ftl");
      } catch (Exception e){
        attributes.put("message", "There was an error" + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());


    get("/current_users", (request, response) -> {
      Map<String, Object> viewObjects = new HashMap<String, Object>();

      ArrayList<Users> users = usersDbService.readAll();

      if(users.isEmpty()) {
        viewObjects.put("hasNoUsers", "Sorry there is no current users");
      } else {

        Deque<Users> showUsers = new ArrayDeque<Users>();

        for(Users user : users) {

            showUsers.addFirst(user);

        }

        viewObjects.put("users", showUsers);
      }

      viewObjects.put("templateName", "usersList.ftl");

      return modelAndView(viewObjects, "layout.ftl");
    }, new FreeMarkerEngine());


    get("/current_users/update/:id", (request, response) -> {

      Integer id = Integer.parseInt(request.params(":id"));
      Map<String, Object> viewObjects = new HashMap<String, Object>();

      viewObjects.put("templateName", "userForm.ftl");

                /* Refactor */
      // Use the readOne to fetch an article by its unique id
      viewObjects.put("user", usersDbService.readOne(id));

      return modelAndView(viewObjects, "layout.ftl");
    }, new FreeMarkerEngine());


    post("/current_users/update/", (request, response) -> {
      Integer id      = Integer.parseInt(request.queryParams("user-id"));
      String username = request.queryParams("user-name");
      String firstName    = request.queryParams("first-name");
      String lastName  = request.queryParams("last-name");
      String password  = request.queryParams("password");

                /* Refactor */
      // The articleDbService handles all the updating once it has
      // be provided with the correct data
      usersDbService.update(id, firstName, lastName, username, password);

      response.status(200);
      response.redirect("/current_users");
      return "";

    });

    get("/current_users/delete/:id", (request, response) -> {

      Integer id = Integer.parseInt(request.params(":id"));

      usersDbService.delete(id);

      response.status(200);
      response.redirect("/current_users");

      return "";
    });


    get("/all-users", (request, response) -> {
      return usersDbService.readAll();
    }, gson::toJson);


    get("/all-users/:id", (request, response) -> {
      response.type("application/json");
      Integer id = Integer.parseInt(request.params(":id"));
      return usersDbService.readOne(id);
    }, gson::toJson);


    get("/aziz", (request, response) -> {
      return usersDbService.readAll();
    }, gson::toJson);


    get("/all-courses", (request, response) -> {
      return coursesDbService.readAll();
    }, gson::toJson);

    get("/all-instructors", (request, response) -> {
      return instructorsDbService.readAll();
    }, gson::toJson);

    get("/courses", (request, response) -> {
      try {
        response.type("text/xml");
        return coursesDbService.getAllCourses();
      } catch (Exception e){
        return e;
      }
    });





  }

}
