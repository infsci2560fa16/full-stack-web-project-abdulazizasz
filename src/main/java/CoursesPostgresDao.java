import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
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
/**
 * Created by abdulaziz on 11/23/16.
 */
public class CoursesPostgresDao<T extends Courses> implements CoursesDbService<T> {

    private Connection conn;
    private Statement stmt;

    public CoursesPostgresDao(){
        String user = "abdulaziz";
        String passwd = "";
        String dbName = "ischoolera";
        String uri = "jdbc:postgresql://localhost/" + dbName;

        try {
            conn = DriverManager.getConnection(uri, user, passwd);
            stmt = conn.createStatement();

            System.out.println("Connecting to PostgreSQL database succeed");
        } catch(Exception e) {
            System.out.println(e.getMessage());

            try {
                if(null != stmt) {
                    stmt.close();
                }
                if(null != conn) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }



    @Override
    @SuppressWarnings("unchecked")
    public T readOne(int id) {
        try {
            String selectQuery = "SELECT * FROM courses where id = ?";

            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            pstmt.setInt(1, id);

            pstmt.executeQuery();

            // A ResultSet is Class which represents a table returned by a SQL query
            ResultSet resultSet = pstmt.getResultSet();

            if(resultSet.next()) {
                Courses entity = new Courses(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("area"),
                        resultSet.getString("duration"),
                        resultSet.getString("startingDate"),
                        resultSet.getInt("instructor_id")
                );

                pstmt.close();

                return (T) entity;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());

            try {
                if(null != stmt) {
                    stmt.close();
                }
                if(null != conn) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        return null;

    }

    @Override
    @SuppressWarnings("unchecked") //Tells the compiler to ignore unchecked type casts
    public ArrayList readAll() {
        ArrayList<Courses> results = (ArrayList<Courses>) new ArrayList<T>();

        try {
            String query = "SELECT * FROM courses;";
            stmt.execute(query);
            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                Courses entity = new Courses(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("area"),
                        resultSet.getString("duration"),
                        resultSet.getString("startingDate"),
                        resultSet.getInt("instructor_id")
                );

                results.add(entity);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());

            try {
                if(null != stmt) {
                    stmt.close();
                }
                if(null != conn) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        return (ArrayList<T>) results;
    }

    public String getAllCourses(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/public/xml/courses_instructors.xml"));
            String line;
            StringBuilder xml = new StringBuilder();
            while ((line = br.readLine()) != null){
                xml.append(line.trim());
            }
            return xml.toString();
        } catch (Exception e){
            return e.toString();
        }

    }


}



