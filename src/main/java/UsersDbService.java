import java.util.ArrayList;

/**
 * Created by abdulaziz on 11/23/16.
 */
public interface UsersDbService<T> {
    public Boolean create(T entity);
    public T readOne(int id);
    public ArrayList<T> readAll();
    public Boolean update(int id, String firstName, String lastName, String username, String password);
    public Boolean delete(int id);
}
