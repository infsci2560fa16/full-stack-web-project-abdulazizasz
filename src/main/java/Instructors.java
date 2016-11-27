/**
 * Created by abdulaziz on 11/27/16.
 */
import lombok.Data;



public class Instructors {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    private int id;
    private String name;
    private String email;
    private String experience;

    public Instructors(int id, String name, String email, String experience) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.experience = experience;
    }





}
