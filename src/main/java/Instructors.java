/**
 * Created by abdulaziz on 11/27/16.
 */
import lombok.Data;


@Data
public class Instructors {

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
