/**
 * Created by abdulaziz on 11/27/16.
 */
public class Courses {

    private int id;
    private String name;
    private String area;
    private String duration;
    private String startingDate;
    private int instructor_id;

    public Courses(int id, String name, String area, String duration, String startingDate, int instructor_id) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.duration = duration;
        this.startingDate = startingDate;
        this.instructor_id = instructor_id;
    }

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }
}
