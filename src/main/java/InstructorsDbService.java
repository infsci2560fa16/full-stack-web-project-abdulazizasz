import java.util.ArrayList;

/**
 * Created by abdulaziz on 11/27/16.
 */
public interface InstructorsDbService<T> {

    public T readOne(int id);
    public ArrayList<T> readAll();
}
