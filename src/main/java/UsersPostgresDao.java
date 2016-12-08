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

//import javafx.beans.binding.ObjectExpression;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
/**
 * Created by abdulaziz on 11/23/16.
 */
public class UsersPostgresDao<T extends Users> implements UsersDbService<T> {

    private Connection conn =  null;
    private Statement stmt;

    public UsersPostgresDao() {
//        String user = "abdulaziz";
//        String passwd = "";
//        String dbName = "ischoolera";
//        String uri = "jdbc:postgresql://localhost/" + dbName;
//
//        try {
//            conn = DriverManager.getConnection(uri, user, passwd);
//            stmt = conn.createStatement();
//
//            System.out.println("Connecting to PostgreSQL database succeed");
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//
//            try {
//                if(null != stmt) {
//                    stmt.close();
//                }
//                if(null != conn) {
//                    conn.close();
//                }
//            } catch (SQLException sqlException) {
//                sqlException.printStackTrace();
//            }
//        }


        try {
            conn = DatabaseUrl.extract().getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
    @Override
    public Boolean create(T entity) {
        try{
            String insertQuery = "INSERT INTO users(firstName, lastName, username, password) VALUES(?, ?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);

            pstmt.setString(1, entity.getFirstName());
            pstmt.setString(2, entity.getLastName());
            pstmt.setString(3, entity.getUsername());
            pstmt.setString(4, entity.getPassword());

            pstmt.executeUpdate();

            pstmt.close();

            return true;
        } catch (SQLException e) {
            System.out.print(e.getMessage());

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

            return false;

        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T readOne(int id) {
        try {
            String selectQuery = "SELECT * FROM users where id = ?";

            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            pstmt.setInt(1, id);

            pstmt.executeQuery();

            // A ResultSet is Class which represents a table returned by a SQL query
            ResultSet resultSet = pstmt.getResultSet();

            if(resultSet.next()) {
               Users entity = new Users(
                       resultSet.getInt("id"),
                       resultSet.getString("firstName"),
                       resultSet.getString("lastName"),
                       resultSet.getString("username"),
                       resultSet.getString("password")
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
        ArrayList<Users> results = (ArrayList<Users>) new ArrayList<T>();

        try {
            String query = "SELECT * FROM users;";
            stmt.execute(query);
            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                Users entity = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
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

    @Override
    public Boolean update(int id, String firstName, String lastName, String username, String password) {
        try {
            String updateQuery =
                    "UPDATE users SET firstName = ?, lastName = ? , username = ?, password = ?" +
                            "WHERE id = ?;"
                    ;

            PreparedStatement pstmt = conn.prepareStatement(updateQuery);


            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, username);
            pstmt.setString(4, password);

            pstmt.setInt(5, id);

            pstmt.executeUpdate();
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

        return true;
    }

    @Override
    public Boolean delete(int id) {
        try {
            String deleteQuery = "DELETE FROM users WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (Exception e) {
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

        return true;
    }
}



