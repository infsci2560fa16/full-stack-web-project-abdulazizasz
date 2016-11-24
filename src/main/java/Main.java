import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main {

  public static void main(String[] args) {

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


    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());

  }

}
