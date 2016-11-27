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

import javafx.beans.binding.ObjectExpression;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
/**
 * Created by abdulaziz on 11/23/16.
 */
public class InstructorsPostgresDao<T extends Instructors> implements InstructorsDbService<T> {

    private Connection conn;
    private Statement stmt;

    public InstructorsPostgresDao(){
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
            String selectQuery = "SELECT * FROM instructors where id = ?";

            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            pstmt.setInt(1, id);

            pstmt.executeQuery();

            // A ResultSet is Class which represents a table returned by a SQL query
            ResultSet resultSet = pstmt.getResultSet();

            if(resultSet.next()) {
                Instructors entity = new Instructors(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("experience")

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
        ArrayList<Instructors> results = (ArrayList<Instructors>) new ArrayList<T>();

        try {
            String query = "SELECT * FROM instructors;";
            stmt.execute(query);
            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                Instructors entity = new Instructors(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("experience")

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


}



